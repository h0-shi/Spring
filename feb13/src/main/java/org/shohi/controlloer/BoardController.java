package org.shohi.controlloer;

import java.util.List;

import org.shohi.dto.BoardDTO;
import org.shohi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//게시판 관련 기능을 여기다가 넣는다

@Controller
public class BoardController {
	
	//서비스와 연결하기
	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public String board (Model model) {
		/*
		 * DB에서 값을 불러와서 화면에 찍는다.
		 * 불러오다 = model, 찍는다 jsp
		 * Controller = 흐름 제어
		 * service = 로직
		 * Repository = DAO
		 */
		System.out.println("컨트롤러입니다.");
		//Service에게 일 시키기
		List<BoardDTO> list = boardService.boardList();
		
		//붙이기  -  setAttribute랑 같은거
		model.addAttribute("list", list);

		return "board"; // = jsp file name
	}
}
