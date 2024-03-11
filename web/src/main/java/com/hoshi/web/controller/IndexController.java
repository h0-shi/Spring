package com.hoshi.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoshi.web.service.IndexService;
import com.hoshi.web.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	@Autowired
	private Util util;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("menu",menu);
		return "index";
	}
	
	@GetMapping("/")
	public String index2(Model model) {
		return index(model);
	}
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(name="cate", defaultValue = "1",required = false) int cate, Model model) {
		//메뉴 불러오기
		List<Map<String, Object>> fb = indexService.freeBoard(cate);
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("cateName",indexService.cateName(cate));
		model.addAttribute("menu",menu);
		model.addAttribute("fb",fb);
		return "freeboard";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			List<Map<String, Object>> menu = indexService.menu();
			model.addAttribute("menu",menu);
			return "write";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam Map<String, Object> map) {
		//System.out.println(map);
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			int result = indexService.write(map);
			//System.out.println(result);
			return "freeboard";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		List<Map<String, Object>> menu = indexService.menu();
		model.addAttribute("menu",menu);
		Map<String, Object> detail = indexService.detail(no);
		model.addAttribute("detail",detail);
		return "detail";
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no, @RequestParam("cate") int cate) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
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
		} return "redirect:/login";
		
	}
	
	@GetMapping("/postUpdate")
	public String postUpdate(@RequestParam("mtno") int mtno, Model model) {
		HttpSession session = util.getSession();
		if(session.getAttribute("mname")!=null || session.getAttribute("mid")!=null) {
			Map<String, Object> detail = indexService.detail(mtno);
			List<Map<String, Object>> menu = indexService.menu();
			model.addAttribute("menu",menu);
			model.addAttribute("detail",detail);
			return "update";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate(@RequestParam Map<String, Object> map) {
		HttpSession session = util.getSession();
		String mname = session.getAttribute("mname")+"";
		if(mname == map.get("mname")) {
			int result = indexService.postUpdate(map);
			return "redirect:/detail?no="+map.get("mtno");
		}
		return "redirect:/login";
	}
	
	

}
