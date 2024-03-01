package org.hoshi.dao;

import java.util.List;

import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.SearchDTO;
import org.hoshi.dto.WriteDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends AbstractDAO {
	
	public List<BoardDTO> boardList(SearchDTO searchDTO){
		System.out.println(searchDTO.getSearch()+"--------------------*********************");
		return sqlSession.selectList("board.boardList", searchDTO);
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

	public int postDel(WriteDTO dto) {
		return sqlSession.update("board.postDel",dto);
	}

	public int totalRecordCount(String search) {
		return sqlSession.selectOne("board.totalRecordCount", search);
	}
	
	public int deleteComment(CommentDTO dto) {
		return sqlSession.update("board.commentDelete",dto);
	}

	public int liekUp(CommentDTO dto) {
		return sqlSession.update("board.likeUp",dto);
	}

	public int countUp(BoardDTO dto) {
		return sqlSession.insert("board.countUp",dto);
	}
}
