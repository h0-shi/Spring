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
	public List<NoticeDTO> noticeList() {
		return noticeDAO.noticeList();
	}

}
