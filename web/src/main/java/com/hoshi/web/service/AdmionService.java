package com.hoshi.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.dao.AdminDAO;

@Service
public class AdmionService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	public List<Map<String, Object>> menu() {
		return adminDAO.menu();
	}

	public int menuInsert(Map<String, Object> map) {
		int result = adminDAO.menuInsert(map);
		return result;
	}

}
