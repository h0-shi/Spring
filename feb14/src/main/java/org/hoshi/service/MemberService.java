package org.hoshi.service;

import java.util.List;
import java.util.Map;

import org.hoshi.dao.MemberDAO;
import org.hoshi.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> memberList(){	//만들어줘야 한다.
		System.out.println("서비스");
		return memberDAO.memberList();
	}

	public List<Map<String, Object>> memberList2() {
		System.out.println("서비스2");
		return memberDAO.memberList2();
	}
	
}
