package org.shohi.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.shohi.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> boardList() {
		System.out.println("DAO 작동");
		System.out.println("mybatis에게 일을 시킨다.");
		return sqlSession.selectList("board.boardList"); // 네임스페이스.ID
	}

}
