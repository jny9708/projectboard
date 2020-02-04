package com.young.web.board.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	int id;
	String title;
	String content;
	Date register_date;
	Date edit_date;
	int member_id;
	int view_count;
	int comment_count;

}
