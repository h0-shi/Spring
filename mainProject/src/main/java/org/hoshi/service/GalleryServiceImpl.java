package org.hoshi.service;

import java.util.List;

import org.hoshi.dao.GalleryDAO;
import org.hoshi.dto.GalleryDTO;
import org.hoshi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl extends AbstractService implements GalleryService {
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	@Override
	public int galleryInsert(GalleryDTO dto) {
		if(util.getSession().getAttribute("mid")!= null) {
			dto.setMid(util.getSession().getAttribute("mid")+"");
			System.out.println("서비스");
			return galleryDAO.galleryInsert(dto);
		} else {
			return 0;
		}
	}
	
	@Override
	public List<GalleryDTO> galleryList() {
		return galleryDAO.galleryList();
	}

	@Override
	public GalleryDTO galleryDetail(int no) {
		return galleryDAO.galleryDetail(no);
	}

	@Override
	public int galleryDel(int no) {
		return galleryDAO.galleryDel(no);
	}

}
