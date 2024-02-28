package org.hoshi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.ibatis.annotations.Param;
import org.hoshi.dto.LoginDTO;
import org.hoshi.dto.MemberDTO;
import org.hoshi.service.LoginService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Util util;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setId(id);
		loginDTO.setPw(pw);
		
		//dto가 들어가서 mname 나옴
		LoginDTO login = loginService.login(loginDTO);
		if(login.getCount() ==1 && login.getMcount() < 5) {
			if(login.getPw().equals(loginDTO.getPw())) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", id);
				session.setAttribute("mname", login.getMname());
				loginService.mcountDown(loginDTO);
			} else {
				loginService.mcountUp(loginDTO);
				return "redirect:/login?count="+login.getMcount();
			}
		} else if(login.getCount() ==1 && login.getMcount() > 5){
			loginService.mcountUp(loginDTO);
			return "redirect:/login?count="+login.getMcount();
		} else {
			return "redirect:/login?login=2048";
		}
		return "redirect:/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("mid") != null) {
			session.removeAttribute("mid");
		}
		if(session.getAttribute("mname") != null) {
			session.removeAttribute("mname");
		}
		session.invalidate();//이게 뭘까
		
		return "redirect:/login";
	}
	
	@GetMapping("/myInfo@{id}")
	public String myInfo(@PathVariable("id") String id) throws EmailException {
		if(util.getSession().getAttribute("mid")!=null) {
			//ajax 용으로 빼둔다?
			return "myinfo";
		}
		return "redirect:/login?error=error";
	}
	
	/*
	 * 아이디 -> 중복검사
	 * 이메일 -> 중복검사
	 * 비밀번호 / 비밀번호 확인
	 * 닉네임
	 */
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int result = loginService.join(dto);
		System.out.println("진입");
		System.out.println(dto.getMid());
		System.out.println("진입");
		return "redirect:/index";
	}
	
	@PostMapping("/idCheck")
	public @ResponseBody int idCheck(@RequestParam("id") String id) {
		int result = loginService.idCheck(id);
		return result;
	}
	@PostMapping("/emailCheck")
	public @ResponseBody int emailCheck(@RequestParam("email") String email) {
		int result = loginService.emailCheck(email);
		return result;
	}
	 
}
