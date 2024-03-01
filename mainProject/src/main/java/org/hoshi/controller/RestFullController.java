package org.hoshi.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hoshi.dto.BoardDTO;
import org.hoshi.service.BoardService;
import org.hoshi.service.LoginService;
import org.hoshi.service.RestService;
import org.hoshi.util.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@RestController
public class RestFullController {
	
	@Autowired BoardService boardService;
	@Autowired RestService restService;
	@Autowired LoginService loginService;
	@Autowired Util util;
	
	@PostMapping("/restDetail")
	public BoardDTO restDetail(@Param("no") int no) {
		BoardDTO detail = boardService.detail(no);
		return detail;
	}
	
	@PostMapping("/emailAuth")
	public int emailAuth() {
		return restService.sendEmail();
	}
	
	@PostMapping("/idCheck")
	public int idCheck(@RequestParam("id") String id) {
		int result = loginService.idCheck(id);
		JSONObject json = new JSONObject();
		//count라는 이름으로 result 를 담는다.
		json.put("count", result);
		return result;
	}
	
	@PostMapping("/emailCheck")
	public int emailCheck(@RequestParam("email") String email) {
		int result = loginService.emailCheck(email);
		return result;
	}
	
	@GetMapping("/jsonBoard")
	public String jsonBoard(@RequestParam("pageNo") String pageNo) {
		
		int currentPageNo = 1;

		if(util.str2Int(pageNo)>0) { //여기 수정이 필요하다.숫자가 아니면1, 숫자면 그 숫자로.
			currentPageNo = Integer.parseInt(pageNo);
		}
		//전체 글 수 totalCount
		int totalRecordCount = boardService.totalRecordCount("");
		//Pagination
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);//현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10);//페이지당 게시글
		paginationInfo.setPageSize(10);//페이징 리스트 사이즈
		paginationInfo.setTotalRecordCount(totalRecordCount);//전체 게시글
		
		//List<BoardDTO> list = boardService.boardList(paginationInfo.getFirstRecordIndex());
		
		//json
		JSONObject jsonList = new JSONObject();
		//jsonList.put("list", list);
		jsonList.put("paginationInfo", paginationInfo);
		jsonList.put("pageNo", pageNo);
		
		return jsonList.toString();
	}
	
}
