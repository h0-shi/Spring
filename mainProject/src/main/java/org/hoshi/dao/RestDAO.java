package org.hoshi.dao;

import org.hoshi.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RestDAO extends AbstractDAO {

	public String getEmail(String id) {
		return sqlSession.selectOne("rest.getEmail", id);
	}

	public void setKey(MemberDTO dto) {
		sqlSession.update("rest.setKey", dto);
	}
	
	public int idCheck(String id) {
		return sqlSession.selectOne("rest.idCheck",id);
	}
	
	public int emailCheck(String email) {
		return sqlSession.selectOne("rest.emailCheck",email);
	}
	
}
