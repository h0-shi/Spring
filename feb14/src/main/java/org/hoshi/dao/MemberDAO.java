package org.hoshi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDTO> memberList(){
		System.out.println("DAO");
		return sqlSession.selectList("member.memberList");
	}

	public List<Map<String, Object>> memberList2() {
		System.out.println("DAO2");
		return sqlSession.selectList("member.memberList2");
	}

}
