package org.hoshi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hoshi.dao.BoardDAO;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> boardList(int pageNo){
		return boardDAO.boardList(pageNo);
	}

	public BoardDTO detail(int no) {
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		dto.setMid(session.getAttribute("mid")+"");
		return boardDAO.write(dto);
		
	}

	public int commentWrite(CommentDTO comment) {
		return boardDAO.commentwrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentList(no);
	}

	public int postDel(int no) {
		return boardDAO.postDel(no);
	}

	public int totalRecordCount() {
		return boardDAO.totalRecordCount();
	}

}
