package org.hoshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/admin")
	public String index2() {
		return "admin/index";
	}
	
	@GetMapping("")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/join")
	public String join() {
		return "admin/join";
	}
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	@GetMapping("/adminBoard")
	public String adminBoard() {
		return "admin/adminBoard";
	}

}
