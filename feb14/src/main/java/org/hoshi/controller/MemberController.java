package org.hoshi.controller;

import java.util.List;
import java.util.Map;

import org.hoshi.dto.MemberDTO;
import org.hoshi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; 

	// /member
	@GetMapping("/member")
	public String member(Model model) {
		//service가 준다. model에 값을 붙인다.
		List<MemberDTO> lists = memberService.memberList();
		model.addAttribute("list", lists);
		System.out.println("컨트롤러");
     		return "member";
	}
	
	@GetMapping("/member2")
	public ModelAndView /*String*/ member2(/*Model model*/) {
		List<Map<String, Object>> lists = memberService.memberList2();
		
		ModelAndView mv = new ModelAndView("member2");
		mv.addObject("list", lists);
		
		//model.addAttribute("list", lists);
		System.out.println("컨트롤러2");
		
		/*return "member";*/
		return mv;
	}
	
	@GetMapping("/member3")
	public @ResponseBody MemberDTO member3() {
		List<MemberDTO> lists = memberService.memberList();
		return lists.get(0);
	}
	
}
