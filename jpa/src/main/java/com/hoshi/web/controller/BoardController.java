package com.hoshi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoshi.web.entity.JPABoard;
import com.hoshi.web.entity.JPAMember;
import com.hoshi.web.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/board";
	}
	
	@GetMapping("/board")
	public String board(Model model) {
		List<JPABoard> list = boardService.boardLsit();
		model.addAttribute("list",list);
		return "board";
	}
	
	@GetMapping("/detail")
	public String detial(@RequestParam("no") int no, Model model) {
		JPABoard detail = boardService.detail(no);
		model.addAttribute("detail",detail);
		return "detail";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam("title") String title, @RequestParam("content") String content) {
		JPABoard post = new JPABoard();
		post.setJbcontent(content);
		post.setJbtitle(title);
		
		JPAMember member = new JPAMember();
		String mid = "shohi";
		member = boardService.findByJmid(mid);
		
		post.setJpaMember(member);
		boardService.write(post);
		return "redirect:/board";
	}
	
	@GetMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		//deleteById
		//boardService.postDel(no);
		//delete
		JPABoard post = new JPABoard();
		post.setJbno(no);
		boardService.postDel2(post); 
		return "redirect:/board";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("no") int no,Model model) {
		JPABoard post = boardService.detail(no);
		model.addAttribute("detail",post);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("no") int no, @RequestParam("title") String title, @RequestParam("content") String content) {
		JPABoard update = new JPABoard();
		update.setJbcontent(content);
		update.setJbtitle(title);
		update.setJbno(no);
		boardService.update(update);
		return "redirect:/detail?no="+no;
	}
	
}
