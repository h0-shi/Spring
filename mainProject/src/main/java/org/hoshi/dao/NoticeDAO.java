package org.hoshi.dao;

import java.util.List;

import org.hoshi.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO extends AbstractDAO {

	public List<NoticeDTO> noticeList(int no) {
		return sqlSession.selectList("notice.noticeList", no);
	}

	public NoticeDTO noticeDetail(int no) {
		return sqlSession.selectOne("notice.noticeDetail",no);
	}

	public int noticeWrite(NoticeDTO dto) {
		return sqlSession.insert("notice.noticeWrite", dto);
	}

	public int noticeDel(int no) {
		return sqlSession.update("notice.noticeDel",no);
	}

	public int totalRecordCount() {
		return sqlSession.selectOne("notice.totalRecordCount");
	}

	
	
}
