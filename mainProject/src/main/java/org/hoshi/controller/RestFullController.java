package org.hoshi.controller;

import org.apache.ibatis.annotations.Param;
import org.hoshi.dto.BoardDTO;
import org.hoshi.service.BoardService;
import org.hoshi.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestFullController {
	
	@Autowired BoardService boardService;
	
	@Autowired RestService restService;
	
	@PostMapping("/restDetail")
	public @ResponseBody BoardDTO restDetail(@Param("no") int no) {
		BoardDTO detail = boardService.detail(no);
		return detail;
	}
	
	@PostMapping("/emailAuth")
	public int emailAuth() {
		return restService.sendEmail();
	}
	
}
