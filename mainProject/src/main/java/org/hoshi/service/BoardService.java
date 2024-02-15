package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.BoardDAO;
import org.hoshi.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> boardList(){
		return boardDAO.boardList();
	}

	public BoardDTO detail(String no) {
		return boardDAO.detail(no);
	}

}
