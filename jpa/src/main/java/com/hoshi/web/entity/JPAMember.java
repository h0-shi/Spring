package com.hoshi.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JPAMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jmno;
	
	@Column(unique = true, columnDefinition = "VARCHAR(10)", nullable=false)
	private String jmid;
	
	@Column(columnDefinition = "VARCHAR(30)", nullable=false)
	private String jmpw;
	
	@Column(name="jmname", columnDefinition = "VARCHAR(10)")
	private String jmname;
	
	@Column(columnDefinition = "VARCHAR(15)")
	public String jmtel;
}
