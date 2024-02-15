package org.hoshi.controller;


import javax.servlet.http.HttpServletRequest;

import org.hoshi.service.BoardService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private Util util;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board")
	public String board(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "board";
	}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		int no = util.str2Int(request.getParameter("no"));
		model.addAttribute("detail", boardService.detail(no));
		if(no!=0) {
			return "detail";
		} else {
			return "error/error";
		}
	}
	
}
