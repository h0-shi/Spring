package org.hoshi.dao;

import org.hoshi.dto.LoginDTO;
import org.hoshi.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends AbstractDAO {
	public LoginDTO login(LoginDTO dto) {
		return sqlSession.selectOne("login.login",dto);
	}

	public int mcountUp(LoginDTO loginDTO) {
		return sqlSession.update("login.mcountUp",loginDTO);
	}

	public int mcountDown(LoginDTO loginDTO) {
		return sqlSession.update("login.mcountDown",loginDTO);
	}

	public int join(MemberDTO dto) {
		return sqlSession.insert("login.join", dto);
	}

}
