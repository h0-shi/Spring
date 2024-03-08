package com.hoshi.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String freeboard(@RequestParam(name="cate", defaultValue = "1",required = false) int cate, Model model) {
		List<BoardDTO> fb = indexService.freeBoard(cate);
		model.addAttribute("fb",fb);
		return "freeboard";
	}
	
	@GetMapping("/notice")
	public String notice(@RequestParam(name="cate", defaultValue = "2",required = false) int cate, Model model) {
		List<BoardDTO> fb = indexService.freeBoard(cate);
		model.addAttribute("fb",fb);
		return "notice";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam Map<String, Object> map) {
		System.out.println(map);
		int result = indexService.write(map);
		System.out.println(result);
		return "write";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		BoardDTO detail = indexService.detail(no);
		model.addAttribute("detail",detail);
		return "detail";
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no, @RequestParam("cate") int cate) {
		System.out.println(cate+"-------------"+no);
		int result = indexService.postDeil(no);
		switch(cate) {
		case 1 :
			return "redirect:/freeboard";
		case 2:
			return "redirect:/notice?no=2";
		case 3 :
			return "redirect:/notice?no=3";
		case 4 :
			return "redirect:/notice?no=4";
		case 5 :
			return "redirect:/notice?no=5";
		case 6 :
			return "redirect:/notice?no=6";
		default :
			return "redirect:/index";
		}
		
	}

}
