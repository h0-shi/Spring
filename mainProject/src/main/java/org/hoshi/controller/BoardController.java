package org.hoshi.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.WriteDTO;
import org.hoshi.service.BoardService;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private Util util;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board")
	public String board(@RequestParam(value="pageNo", defaultValue="1", required=false) String no, Model model) {
		int currentPageNo = 1;
		if(util.str2Int(no)>0) { //여기 수정이 필요하다.숫자가 아니면1, 숫자면 그 숫자로.
			currentPageNo = Integer.parseInt(no);
		}
		//전체 글 수 totalCount
		int totalRecordCount = boardService.totalRecordCount();
		//Pagination
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);//현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10);//페이지당 게시글
		paginationInfo.setPageSize(10);//페이징 리스트 사이즈
		paginationInfo.setTotalRecordCount(totalRecordCount);//전체 게시글
		
		List<BoardDTO> list = boardService.boardList(paginationInfo.getFirstRecordIndex());
		//getFirstRecordIndex == 첫번째 글 가져오는거
		model.addAttribute("list", list);
		//페이징 관련 정보가 있는 PaginationInfo 객체를 모델에 반드시 넣어준다.
		model.addAttribute("paginationInfo",paginationInfo);
		return "board";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(value = "no", defaultValue="10") String no, Model model) {
		//int no = util.str2Int(request.getParameter("no"));
		if(util.str2Int(no)!=0) {
			int reNo = util.str2Int(no);
			BoardDTO detail = boardService.detail(reNo);
			if(detail.getComment() > 0) {
				List<CommentDTO> commentsList = boardService.commentsList(reNo);
				model.addAttribute("commentsList", commentsList);
			}
			model.addAttribute("detail", detail);
			return "detail";
		} else {
			return "redirect:/error";
		}
	}
	
	@PostMapping("/write") //제목+내용 받음, DB저장, 보드로
	public String write(WriteDTO dto) {
		// 추후 세션 관련 작업 필요
		if(util.getSession().getAttribute("mid") != null ) {
			int result = boardService.write(dto);
			if(result==1) {
				return "redirect:/detail?no="+dto.getBoard_no();
			} else {
				return "redirect:/error";
			}
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/write")
	public String write() {
		return "redirect:/login?error=2048";
	}
	
	//댓글 쓰기 24.02.19 글번호, 댓글내용, 글쓴이
	@PostMapping("/commentWrite")
	public String commentWrite(CommentDTO comment) {
		//HttpSession session =request.getSession();
		//comment.setMid(session.getAttribute("mid")+"");
		if(util.getSession().getAttribute("mid") != null ) {
			int result = boardService.commentWrite(comment);
			return "redirect:/detail?no="+comment.getNo();
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		//로그인 여부 확인 및 정보 확인
		//System.out.println("no : "+no);
		
		if(util.getSession().getAttribute("mid") != null) {
			int result = boardService.postDel(no);
			if(result == 1) {
				return "redirect:/board";
			} else {
				return "redirect:/error";
			}
		}
		return "redirect:/login";
	}
	
	//댓글번호, mid, 글번호 와야 함_댓글번호+글번호를 파라미터로 받자
	@GetMapping("deleteComment")
	public String deleteComment(@RequestParam("no") int no, @RequestParam("cno") int cno) {
		//System.out.println("글번호는 "+no+" 댓글은 "+cno);
		int result = boardService.deleteComment(no, cno);
		return "redirect:/detail?no="+no;
	}
	
	@GetMapping("/likeUp")
	public String likeUp(@RequestParam("no") String no, @RequestParam("cno") String cno) {
		if(util.intCheck(cno)&&util.intCheck(cno)) {
			CommentDTO dto = new CommentDTO(); 
			dto.setBoard_no(util.str2Int(no));
			dto.setNo(util.str2Int(cno));
			
			boardService.likeUp(dto);
			return "redirect:/detail?no="+no;
		} else {
			return "redirect:/error";
		}
	}
	
	
}
