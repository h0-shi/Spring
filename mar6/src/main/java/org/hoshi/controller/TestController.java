package org.hoshi.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hoshi.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@Resource(name="testService")
	private TestService testService;

	@GetMapping("/main.do")
	public ModelAndView main() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list = testService.boardList();
		mv.addObject("list",list);
		return mv;
	}
}
