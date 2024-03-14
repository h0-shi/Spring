package com.hoshi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoshi.web.entity.JPABoard;
import com.hoshi.web.entity.JPAMember;
import com.hoshi.web.repository.BoardRepository;
import com.hoshi.web.repository.MemberRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepositroy;
	@Autowired
	private MemberRepository memberRepository;

	public List<JPABoard> boardLsit() {
		//return boardRepositroy.findAll();
		return boardRepositroy.findAllByOrderByJbnoDesc();
	}

	public JPABoard detail(int no) {
		JPABoard detail = boardRepositroy.findByJbno(no);
		return detail;
	}

	public void write(JPABoard post) {
		boardRepositroy.save(post);
	}

	public void postDel(int no) {
		boardRepositroy.deleteById(no);
	}

	public void postDel2(JPABoard post) {
		boardRepositroy.delete(post);
	}

	public void update(JPABoard post) {
		boardRepositroy.save(post);
	}

	public JPAMember findByJmid(String mid) {
		return memberRepository.findByJmid(mid);
	}
	
	

}
;