package org.hoshi.controller;


import org.apache.ibatis.annotations.Param;
import org.hoshi.dto.WriteDTO;
import org.hoshi.service.BoardService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String detail(@Param("no") String no, Model model) {
		//int no = util.str2Int(request.getParameter("no"));
		if(util.str2Int(no)!=0) {
			model.addAttribute("detail", boardService.detail(util.str2Int(no)));
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
	
}
