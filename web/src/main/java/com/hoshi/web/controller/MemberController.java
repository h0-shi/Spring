package com.hoshi.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoshi.web.service.MemberService;
import com.hoshi.web.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberSerivce;
	@Autowired
	private Util util;
	
	@GetMapping("/login")
	public String login(Model model) {
		List<Map<String, Object>> menu = memberSerivce.menu();
		model.addAttribute("menu",menu);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, Object> map) {
		Map<String, Object> login = memberSerivce.login(map);
		System.out.println(login);
		if(util.str2Int(login.get("count")+"") == 1) {
			//정상 -> 세션 -> 
			HttpSession session = util.getSession();
			session.setAttribute("mname", login.get("mname"));
			session.setAttribute("mid", login.get("mid"));
		}
		return "redirect:/freeboard";
	}
	@GetMapping("/logout")
	public String logout() {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null) {
			session.removeAttribute("mname");
		}
		if(session.getAttribute("mid") !=null) {
			session.removeAttribute("mid");
		}
		session.invalidate();
		
		return "redirect:/login"; 
	}

}
