package org.hoshi.service;

import java.util.List;

import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.SearchDTO;

public interface AdminService {

	public List<BoardDTO> boardList(SearchDTO searchDTO);
	
	public int totalRecordCount(SearchDTO searchDTO);
	
	public int delStatus(BoardDTO boardDTO);
}
