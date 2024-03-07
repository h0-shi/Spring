package com.hoshi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoshi.web.dto.BoardDTO;
import com.hoshi.web.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("test","테스트입니둥다라랑");
		return "index";
	}
	
	@GetMapping("/freeboard")
	public String freeboard(Model model) {
		List<BoardDTO> fb = indexService.freeBoard();
		model.addAttribute("fb",fb);
		return "freeboard";
	}

}
