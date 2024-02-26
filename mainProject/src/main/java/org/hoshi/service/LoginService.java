package org.hoshi.service;

import org.hoshi.dao.LoginDAO;
import org.hoshi.dto.LoginDTO;
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

}
