package org.hoshi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hoshi.dao.BoardDAO;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.WriteDTO;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private Util util;
	
	public List<BoardDTO> boardList(int pageNo){
		return boardDAO.boardList(pageNo);
	}

	public BoardDTO detail(int no) {
		if(util.getSession().getAttribute("mid") != null) {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(no);
			dto.setMid(util.getSession().getAttribute("mid")+"");
			boardDAO.countUp(dto);
		}
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto) {
		//HttpServletRequest request = util.req();
		String str = util.replaceTag(dto.getContent());
		dto.setContent(str);
		dto.setMid(util.getSession().getAttribute("mid")+"");
		dto.setIp(util.getIp());
		return boardDAO.write(dto);
	}

	public int commentWrite(CommentDTO comment) {
		String str = util.replaceTag(comment.getComment());
		comment.setComment(str);
		comment.setMid(util.getSession().getAttribute("mid")+"");
		comment.setCip(util.getIp());
		return boardDAO.commentwrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentList(no);
	}

	public int postDel(int no) {
		WriteDTO dto = new WriteDTO();
		String mid = util.getSession().getAttribute("mid")+"";
		dto.setBoard_no(no);
		dto.setMid(mid);
		return boardDAO.postDel(dto);
	}

	public int totalRecordCount() {
		return boardDAO.totalRecordCount();
	}
	
	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setBoard_no(no);
		dto.setNo(cno);
		dto.setMid(util.getSession().getAttribute("mid")+"");
		return boardDAO.deleteComment(dto);
	}

	public int likeUp(CommentDTO dto) {
		return boardDAO.liekUp(dto);
	}

}
