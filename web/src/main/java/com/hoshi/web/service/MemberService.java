package com.hoshi.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO; 
	
	public Map<String, Object> login(Map<String, Object> map) {
		return memberDAO.login(map);
	}

	public List<Map<String, Object>> menu() {
		return memberDAO.menu();
	}

}
