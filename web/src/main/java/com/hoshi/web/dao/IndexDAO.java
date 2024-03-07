package com.hoshi.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hoshi.web.dto.BoardDTO;

@Repository
@Mapper
public interface IndexDAO {
	
	public List<BoardDTO> freeBoard();

}
