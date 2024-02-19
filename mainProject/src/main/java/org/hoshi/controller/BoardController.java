package org.hoshi.controller;


import java.util.List;

import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.WriteDTO;
import org.hoshi.service.BoardService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String detail(@RequestParam(value = "no", defaultValue="10") String no, Model model) {
		//int no = util.str2Int(request.getParameter("no"));
		if(util.str2Int(no)!=0) {
			int reNo = util.str2Int(no);
			BoardDTO detail = boardService.detail(reNo);
			if(detail.getComment() > 0) {
				List<CommentDTO> commentsList = boardService.commentsList(reNo);
				model.addAttribute("commentsList", commentsList);
			}
			model.addAttribute("detail", detail);
			return "detail";
		} else {
			return "redirect:/error";
		}
	}
	
	@PostMapping("/write") //제목+내용 받음, DB저장, 보드로
	public String write(WriteDTO dto) {
		int result = boardService.write(dto);
		// 추후 세션 관련 작업 필요
		if(result==1) {
			return "redirect:/detail?no="+dto.getBoard_no();
		} else {
			return "redirect:/error";
		}
	}
	
	//댓글 쓰기 24.02.19 글번호, 댓글내용, 글쓴이
	@PostMapping("/commentWrite")
	public String commentWrite(CommentDTO comment) {
		int result = boardService.commentWrite(comment);
		System.out.println("결과 : " + result);
		return "redirect:/detail?no="+comment.getNo();
	}
	
}
