package com.hoshi.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.dao.IndexDAO;
import com.hoshi.web.dto.BoardDTO;
import com.hoshi.web.util.Util;

@Service
public class IndexService {
	
	@Autowired
	private IndexDAO indexDAO;
	@Autowired
	private Util util;
	
	public List<BoardDTO> freeBoard(int cate){
		return indexDAO.freeBoard(cate);
	}

	public int write(Map<String, Object> map) {
		map.put("mid", "hoshi");
		map.put("mtip", util.getIp());
		return indexDAO.write(map);
	}

	public BoardDTO detail(int no) {
		return indexDAO.detail(no);
	}

	public int postDeil(int no) {
		return indexDAO.postDel(no);
	}

}
