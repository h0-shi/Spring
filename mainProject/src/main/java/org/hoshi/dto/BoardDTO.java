package org.hoshi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int board_no, board_count, comment;
	private String board_title, mname, mid, board_date, board_content, board_del;

}
