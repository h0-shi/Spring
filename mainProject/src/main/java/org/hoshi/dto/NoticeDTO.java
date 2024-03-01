package org.hoshi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
	
	private int nno, ndel, ncount, nlike;
	private String ntitle, ncontent, ndate, mid, mname;
}
