package org.hoshi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hoshi.dto.LoginDTO;
import org.hoshi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
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
		session.invalidate();
		
		return "redirect:/login";
	}
}
