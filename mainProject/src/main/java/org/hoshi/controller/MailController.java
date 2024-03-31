package org.hoshi.controller;

import org.apache.commons.mail.EmailException;
import org.hoshi.service.MailService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	
	@Autowired
	private MailService2 mailService;
	
	@GetMapping("/mail")
	public String mail() {
		return "mail";
	}
	
	@PostMapping("/mail")
	public String mail(@RequestParam("email") String email, @RequestParam("title") String title, @RequestParam("content") String content) throws EmailException {
//		System.out.println("email : "+email);
//		System.out.println("title : "+title);
//		System.out.println("content : "+content);
		
		mailService.sendTextMail(email, title, content);
		mailService.sendHtmlMail(email, title, content);
		return "redirect:/mail";
	}
}
