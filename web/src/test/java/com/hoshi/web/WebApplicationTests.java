package com.hoshi.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hoshi.web.service.MemberService;

@SpringBootTest
class WebApplicationTests {

	@Autowired
	MemberService memberService;
	
	@DisplayName("로그인 카운트 값 확인합니다.")
	@Test
	void contextLoads() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "hoshi");
		map.put("pw", "0000");
		
		map = memberService.login(map);
		assertEquals("1", map.get("count")+"");
	}

}
