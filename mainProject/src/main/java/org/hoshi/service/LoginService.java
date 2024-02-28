package org.hoshi.service;

import org.hoshi.dao.LoginDAO;
import org.hoshi.dto.LoginDTO;
import org.hoshi.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public LoginDTO login(LoginDTO dto) {
		return loginDAO.login(dto);
	}

	public int mcountUp(LoginDTO loginDTO) {
		return loginDAO.mcountUp(loginDTO);
	}

	public int mcountDown(LoginDTO loginDTO) {
		return loginDAO.mcountDown(loginDTO);
	}

	public int join(MemberDTO dto) {
		return loginDAO.join(dto);
	}

	public int idCheck(String id) {
		return loginDAO.idCheck(id);
	}
	
	public int emailCheck(String email) {
		return loginDAO.emailCheck(email);
	}

}
