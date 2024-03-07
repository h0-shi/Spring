package com.hoshi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.dao.IndexDAO;
import com.hoshi.web.dto.BoardDTO;

@Service
public class IndexService {
	
	@Autowired
	private IndexDAO indexDAO;
	
	public List<BoardDTO> freeBoard(){
		return indexDAO.freeBoard();
	}

}
