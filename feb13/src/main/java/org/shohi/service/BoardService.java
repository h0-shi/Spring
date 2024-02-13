package org.shohi.service;

import java.util.List;

import org.shohi.dao.BoardDAO;
import org.shohi.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public List<BoardDTO> boardList() {
		System.out.println("서비스입니다.");
		
		List<BoardDTO> list = boardDAO.boardList();
		return list;
	}

}
