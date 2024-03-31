package com.hoshi.web.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JPABoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jbno;
	
	@Column(name="jbtitle", columnDefinition = "VARCHAR(50)")
	private String jbtitle;
	
	@Column(columnDefinition = "LONGTEXT")
	private String jbcontent;
	
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime jbdate = LocalDateTime.now();
	
	@ColumnDefault("0")
	private int jblike = 0;
	
	@ColumnDefault("1")
	private int jbread = 1;
	
	@ManyToOne
	@JoinColumn
	private JPAMember jpaMember;
}
