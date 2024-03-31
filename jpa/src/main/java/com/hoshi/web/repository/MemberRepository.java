package com.hoshi.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoshi.web.entity.JPAMember;

public interface MemberRepository extends JpaRepository<JPAMember, Integer>{

	JPAMember findByJmid(String mid);
	
	

}
