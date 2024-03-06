package org.hoshi.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hoshi.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceeImpl implements TestService{
	
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private TestDAO testDAO;

	@Override
	public List<Map<String, Object>> boardList() {
		return testDAO.boardList();
	}

}
