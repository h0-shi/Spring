package org.hoshi.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private int mno, mgrade;
	private String mid, mname;
	private LocalDateTime mdate;
}
