package org.shohi.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int board_no, board_count, comment;
	private String board_title, board_write, board_date;
}
