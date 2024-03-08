package com.hoshi.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hoshi.web.dto.BoardDTO;

@Repository
@Mapper
public interface IndexDAO {
	
	public List<BoardDTO> freeBoard(int cate);

	public int write(Map<String, Object> map);

	public BoardDTO detail(int no);

	public int postDel(int no);

}
