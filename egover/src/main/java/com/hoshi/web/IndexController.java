package com.hoshi.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hoshi.web.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("test","서버에서 온 값");
		List<Map<String, Object>> list = indexService.boardList();
		mv.addObject("list", list);
		return mv;
	}

}
