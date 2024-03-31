package com.hoshi.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IndexDAO {
	
	public List<Map<String, Object>> freeBoard(int cate);

	public int write(Map<String, Object> map);

	public Map<String, Object> detail(int no);

	public int postDel(int no);

	public List<Map<String, Object>> menu();

	public int postUpdate(Map<String, Object> map);

	public String cateName(int cate);

}
