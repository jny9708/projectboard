package com.young.web.comment.service;

import java.util.List;

import com.young.web.comment.model.CommentVO;

public interface CommentService {
	public int insertComment(CommentVO commentVO);
	public List<CommentVO> getCommentList(int id);
	public int updateComment(CommentVO commentVO);
	public int deleteComment(int id);
	
}
