package com.hoshi.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hoshi.web.entity.JPABoard;
import com.hoshi.web.service.BoardService;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	BoardService boardService;
	
	@Test
	@DisplayName("detailCheck")
	void contextLoads() {
		JPABoard detail = boardService.detail(3);
		assertEquals("민수의 추억",detail.getJbtitle());
	}

}
