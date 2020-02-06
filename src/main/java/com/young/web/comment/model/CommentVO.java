package com.young.web.comment.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentVO {
	
	int id;
	int board_id;
	int member_id;
	String content;
	String register_date;
	String edit_date;
	String userid;
}
