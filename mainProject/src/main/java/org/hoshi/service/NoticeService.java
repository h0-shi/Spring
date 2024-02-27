package org.hoshi.service;

import java.util.List;

import org.hoshi.dto.NoticeDTO;

public interface NoticeService {
	
	public List<NoticeDTO> noticeList(int no);
	
	public NoticeDTO noticeDetail(int no);
	
	public int noticeWrite(NoticeDTO dto);
	
	public int noticeDel(int no);
	
	public int noticeUpdate(NoticeDTO dto);
	
	
}
