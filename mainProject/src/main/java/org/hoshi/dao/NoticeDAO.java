package org.hoshi.dao;

import java.util.List;

import org.hoshi.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO extends AbstractDAO {

	public List<NoticeDTO> noticeList() {
		return sqlSession.selectList("notice.noticeList");
	}

	
	
}
