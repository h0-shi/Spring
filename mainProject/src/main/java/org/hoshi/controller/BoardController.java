package org.hoshi.controller;


import javax.servlet.http.HttpServletRequest;

import org.hoshi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "board";
	}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
		model.addAttribute("detail", boardService.detail(no));
		return "detail";
	}
	
}
