package org.hoshi.dao;

import java.util.List;

import org.hoshi.dto.GalleryDTO;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDAO extends AbstractDAO {
	
	public int galleryInsert(GalleryDTO dto) {
		System.out.println("DAO 확인");
		return sqlSession.insert("gallery.galleryInsert",dto);
	}

	public List<GalleryDTO> galleryList() {
		return sqlSession.selectList("gallery.galleryList");
	}

	public GalleryDTO galleryDetail(int no) {
		return sqlSession.selectOne("gallery.galleryDetail", no);
	}

	public int galleryDel(int no) {
		return sqlSession.update("gallery.galleryDel", no);
	}

}
