package org.hoshi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> boardList(){
		return sqlSession.selectList("board.boardList");
	}

	public BoardDTO detail(int no) {
		return sqlSession.selectOne("board.detail", no);
	}

	public int write(WriteDTO dto) {
		return sqlSession.insert("board.write",dto);
	}

	public int commentwrite(CommentDTO comment) {
		return sqlSession.insert("board.commentWrite",comment);
	}

	public List<CommentDTO> commentList(int no) {
		return sqlSession.selectList("board.commentsList", no);
	}
}
