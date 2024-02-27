package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.NoticeDAO;
import org.hoshi.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends AbstractService implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> noticeList(int no) {
		return noticeDAO.noticeList(no);
	}
	
	@Override
	public NoticeDTO noticeDetail(int no) {
		return noticeDAO.noticeDetail(no);
	}
	
	@Override
	public int noticeWrite(NoticeDTO dto) {
		return noticeDAO.noticeWrite(dto);
	}
	
	@Override
	public int noticeDel(int no) {
		return noticeDAO.noticeDel(no);
	}
	
	@Override
	public int noticeUpdate(NoticeDTO dto) {
		return 0;
	}

	public int totalRecordCount() {
		return noticeDAO.totalRecordCount();
	}

}
