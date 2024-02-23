package org.hoshi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hoshi.dto.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int galleryInsert(GalleryDTO dto) {
		System.out.println("DAO 확인");
		return sqlSession.insert("gallery.galleryInsert",dto);
	}

	public List<GalleryDTO> galleryList() {
		return sqlSession.selectList("gallery.galleryList");
	}

}
