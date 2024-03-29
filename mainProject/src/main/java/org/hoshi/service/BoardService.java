package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.BoardDAO;
import org.hoshi.dto.BoardDTO;
import org.hoshi.dto.CommentDTO;
import org.hoshi.dto.SearchDTO;
import org.hoshi.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends AbstractService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> boardList(SearchDTO searchDTO){
		return boardDAO.boardList(searchDTO);
	}

	public BoardDTO detail(int no) {
		if(util.getSession().getAttribute("mid") != null) {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(no);
			dto.setMid(util.getSession().getAttribute("mid")+"");
			boardDAO.countUp(dto);
		}
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto) {
		//HttpServletRequest request = util.req();
		String str = util.replaceTag(dto.getContent());
		dto.setContent(str);
		dto.setMid(util.getSession().getAttribute("mid")+"");
		dto.setIp(util.getIp());
		return boardDAO.write(dto);
	}

	public int commentWrite(CommentDTO comment) {
		String str = util.replaceTag(comment.getComment());
		comment.setComment(str);
		comment.setMid(util.getSession().getAttribute("mid")+"");
		comment.setCip(util.getIp());
		return boardDAO.commentwrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentList(no);
	}

	public int postDel(int no) {
		WriteDTO dto = new WriteDTO();
		String mid = util.getSession().getAttribute("mid")+"";
		dto.setBoard_no(no);
		dto.setMid(mid);
		return boardDAO.postDel(dto);
	}

	public int totalRecordCount(String search) {
		return boardDAO.totalRecordCount(search);
	}
	
	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setBoard_no(no);
		dto.setNo(cno);
		dto.setMid(util.getSession().getAttribute("mid")+"");
		return boardDAO.deleteComment(dto);
	}

	public int likeUp(CommentDTO dto) {
		return boardDAO.liekUp(dto);
	}

}
