package org.hoshi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.SearchDTO;
import org.hoshi.service.AdminService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("/admin") 
public class AdminController {
	
	@Resource(name="adminService")
	private AdminService adminService;
	@Autowired
	private Util util;
	
	@GetMapping("/")
	public String index() {
		return "admin/index";
	}
	@GetMapping("")
	public String index3() {
		return "redirect:/admin/";
	}

	@GetMapping("/index")
	public String index2() {
		return "redirect:/admin/";
	}
	 
	@GetMapping("/join")
	public String join() {
		return "admin/join";
	}
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@GetMapping("/board")
	public String board(@RequestParam(name="pageNo", defaultValue ="1", required=false) String pageNo
			,@RequestParam(name="perPage", defaultValue="1", required=false) String perPage
			,@RequestParam(name="search", required = false) String search
			,@RequestParam(name="searchTitle", required = false) String searchTitle
			,Model model) {
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(util.str2Int(pageNo));
		paginationInfo.setRecordCountPerPage(util.str2Int(perPage)*10);
		paginationInfo.setPageSize(10);
		
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		searchDTO.setPageNo(paginationInfo.getFirstRecordIndex());
		searchDTO.setSearch(search);
		searchDTO.setSearchTitle(searchTitle);
		
		paginationInfo.setTotalRecordCount(adminService.totalRecordCount(searchDTO));
		
		List<BoardDTO> list = adminService.boardList(searchDTO);
		model.addAttribute("list",list);
		model.addAttribute("paginationInfo",paginationInfo);
		model.addAttribute("search",search);
		model.addAttribute("searchTitle",searchTitle);
		model.addAttribute("perPage",perPage);
		return "admin/board";
	}

}
