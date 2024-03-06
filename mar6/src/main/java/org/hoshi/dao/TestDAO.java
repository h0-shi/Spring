package org.hoshi.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> boardList()	{
		return (List<Map<String, Object>>) selectList("test.boardList");
	}
	
}
