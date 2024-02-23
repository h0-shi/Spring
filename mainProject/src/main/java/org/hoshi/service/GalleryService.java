package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.GalleryDAO;
import org.hoshi.dto.GalleryDTO;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDAO galleryDAO;
	@Autowired
	private Util util;
	
	public int galleryInsert(GalleryDTO dto) {
		if(util.getSession().getAttribute("mid")!= null) {
			dto.setMid(util.getSession().getAttribute("mid")+"");
			System.out.println("서비스");
			return galleryDAO.galleryInsert(dto);
		} else {
			return 0;
		}
	}

	public List<GalleryDTO> galleryList() {
		return galleryDAO.galleryList();
	}

}
