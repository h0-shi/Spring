package org.hoshi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> boardList(){
		return sqlSession.selectList("board.boardList");
	}

	public BoardDTO detail(String no) {
		return sqlSession.selectOne("board.detail", no);
	}
}