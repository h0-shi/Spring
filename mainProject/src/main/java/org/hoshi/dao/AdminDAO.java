package org.hoshi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO extends AbstractDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return sqlSession.selectList("admin.boardList", searchDTO);
	}
	
	public int totalRocordCount(SearchDTO searchDTO){
		return sqlSession.selectOne("admin.totalRecordCount",searchDTO);
	}

	public int delStatus(BoardDTO boardDTO) {
		return sqlSession.update("admin.delStatus", boardDTO);
	}
}
