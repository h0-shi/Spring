package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.AdminDAO;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl extends AbstractService implements AdminService{

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return adminDAO.boardList(searchDTO);
	}

	@Override
	public int totalRecordCount(SearchDTO searchDTO) {
		return adminDAO.totalRocordCount(searchDTO);
	}

	@Override
	public int delStatus(BoardDTO boardDTO) {
		return adminDAO.delStatus(boardDTO);
	}

	@Override
	public BoardDTO detail(int no) {
		return adminDAO.detail(no);
	}
	
	
}
