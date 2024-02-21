package org.hoshi.dao;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public LoginDTO login(LoginDTO dto) {
		return sqlSession.selectOne("login.login",dto);
	}

	public int mcountUp(LoginDTO loginDTO) {
		return sqlSession.update("login.mcountUp",loginDTO);
	}

	public int mcountDown(LoginDTO loginDTO) {
		return sqlSession.update("login.mcountDown",loginDTO);
	}

}
