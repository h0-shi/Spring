package org.hoshi.service;

import java.util.List;

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
	
	public List<BoardDTO> boardList(){
		return boardDAO.boardList();
	}

	public BoardDTO detail(int no) {
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto) {
		dto.setMid("hoshi");
		return boardDAO.write(dto);
		
	}

	public int commentWrite(CommentDTO comment) {
		comment.setMid("hoshi");
		return boardDAO.commentwrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentList(no);
	}

}
