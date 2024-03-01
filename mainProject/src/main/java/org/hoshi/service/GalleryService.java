package org.hoshi.service;

import java.util.List;

import org.hoshi.dto.GalleryDTO;

public interface GalleryService {
	
	public int galleryInsert(GalleryDTO dto);
	
	public List<GalleryDTO> galleryList();
	
	public GalleryDTO galleryDetail(int no);
	
	public int galleryDel(int no);
	
	
}
