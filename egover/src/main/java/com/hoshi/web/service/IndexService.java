package com.hoshi.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.dao.IndexDAO;

@Service
public class IndexService {
	
	@Autowired
	private IndexDAO indexDAO;
	
	public List<Map<String, Object>> boardList() {
		return indexDAO.boardList();
	}

}
