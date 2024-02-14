package org.hoshi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	//DAO에서 SqlSession 쓸것이라 명명
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String, Object>> boardList(){
		return sqlSession.selectList("board.boardList"); //namespace.id
	}
	
	public List<Map<String, Object>> boardList2(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", 1);
		map.put("board_title", "첫번째 글");
		map.put("board_write", "박시호");
		map.put("board_date", "2024-02-14");
		map.put("board_count", 3);
		map.put("comment", 1);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("board_no", 2);
		map.put("board_title", "두번째 글");
		map.put("board_write", "고종구");
		map.put("board_date", "2024-02-12");
		map.put("board_count", 1);
		map.put("comment", 5);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("board_no", 3);
		map.put("board_title", "세번째 글");
		map.put("board_write", "최양락");
		map.put("board_date", "2024-01-3");
		map.put("board_count", 12);
		map.put("comment", 151);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("board_no", 4);
		map.put("board_title", "네번째 글");
		map.put("board_write", "지원");
		map.put("board_date", "2024-01-1");
		map.put("board_count", 14);
		map.put("comment", 4);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("board_no", 5);
		map.put("board_title", "다섯번째 글");
		map.put("board_write", "리원");
		map.put("board_date", "2024-01-22");
		map.put("board_count", 7);
		map.put("comment", 3);
		list.add(map);
	
		return list;
	}

	public Map<String, Object> detail(String no) {
		return sqlSession.selectOne("board.detail", no);
		//이게 무슨 말이니
	}
}
