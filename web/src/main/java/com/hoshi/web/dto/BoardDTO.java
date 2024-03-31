package com.hoshi.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
		
	private int mtno, mno, mtdel, mtread, mtcate;
	private String mttitle, mtcontent, mtdate, mtip, mname;
	
}
