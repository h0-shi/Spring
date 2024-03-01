package org.hoshi.controller;

import java.util.List;

import org.hoshi.dto.NoticeDTO;
import org.hoshi.service.NoticeServiceImpl;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeServiceImpl noticeService;
	@Autowired
	private Util util; 
	
	@GetMapping("/notice")
	public String noticeList(@RequestParam(value="pageNo", defaultValue="1", required=false) String no, Model model) {
		int currentPageNo = 1;
		if(util.intCheck(no)) {
			currentPageNo = util.str2Int(no);
		}
		int totalRecordCount = noticeService.totalRecordCount();
		
		//Pagination
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(currentPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		paginationInfo.setTotalRecordCount(totalRecordCount);
		
		List<NoticeDTO> list = noticeService.noticeList(paginationInfo.getFirstRecordIndex());
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		return "notice";
	}
	
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(value="no", defaultValue="0", required=true) int no, Model model ) {
		NoticeDTO detail = noticeService.noticeDetail(no);
		System.out.println("엔엔오 "+detail.getNno());
		if(no != 0) {
			model.addAttribute("detail", detail);
			return "noticeDetail";
		} else {
				return "redirect:/error";
		}
	}
	
	@GetMapping("/admin/noticeWrite")
	public String noticeWrite() {
		return "admin/noticeWrite";
	}
	
	@PostMapping("/admin/noticeWrite")
	public String noticeWrite(NoticeDTO dto) {
//		System.out.println(dto.getNcontent());
//		System.out.println(dto.getNtitle());
		
		int result = noticeService.noticeWrite(dto);
		if(result == 1) {
			return "redirect:/notice";
		} else {
			return "redirect:/error";
		}
	}
//	RequestParam(value="no", defaultValue="0", required=true)
	@GetMapping("/noticeDel@{no}")
	public String noticeDel(@PathVariable("no") int no) {
		if(no != 0) {
			int result = noticeService.noticeDel(no);
			if(result==1) {
				return "redirect:/notice";
			} else {
				return "redirect:/error";
			}
		} else {
			return "redirect:/error";
		}
	}
}
