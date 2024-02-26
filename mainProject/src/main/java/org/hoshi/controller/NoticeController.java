package org.hoshi.controller;

import java.util.List;

import org.hoshi.dto.NoticeDTO;
import org.hoshi.service.NoticeService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private Util util; 
	
	@GetMapping("/notice")
	public String noticeList(Model model) {
		List<NoticeDTO> list = noticeService.noticeList();
		model.addAttribute("list", list);
		return "notice";
	}
}
