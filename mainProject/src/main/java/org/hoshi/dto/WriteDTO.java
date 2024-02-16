package org.hoshi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriteDTO {
	private String title, content, mid;
	private int board_no;
}
