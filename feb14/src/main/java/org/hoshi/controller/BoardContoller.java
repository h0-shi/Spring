package org.hoshi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hoshi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 스프링에서 객체 생성하는 방법은
 * @Controller
 * @Service
 * @Reopsitory
 * @Component
 */
@Controller
public class BoardContoller {
	//데이터 흐름
	/*
	 * Controller -> service -> repository -> mybatis -> DB
	 */
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/board")
	public String board(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "board"; // WEB-INF/board.jsp
	}
	
	//파라미터 이름을 맞춰주면 request.getpara 안해도 됨
	@GetMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
		System.out.println(no);
		Map<String, Object> detail = boardService.detail(no);
		model.addAttribute("detail", detail);
		//System.out.println(detail);
		return "detail";
	}
	
}
