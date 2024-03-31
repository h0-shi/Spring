package com.hoshi.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoshi.web.entity.JPABoard;

public interface BoardRepository extends JpaRepository<JPABoard, Integer>{
	@Query(value="SELECT * FROM jpaboard j WHERE j.jbno=?1", nativeQuery = true)
	JPABoard findByJbno(int no);

	List<JPABoard> findAllByOrderByJbnoDesc();

}
