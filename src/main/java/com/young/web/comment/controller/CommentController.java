package com.young.web.comment.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.web.comment.model.CommentVO;
import com.young.web.comment.service.CommentService;

@RestController
public class CommentController {

	@Inject
	CommentService commentService;
	
	@RequestMapping(value="/comment/{id}",method=RequestMethod.GET)
	public List<CommentVO> getCommentList(@PathVariable int id){
		return commentService.getCommentList(id);
	}
	
	@RequestMapping(value="/comment/{id}",method=RequestMethod.POST)
	public int addComment(@RequestBody CommentVO commentVO) {
		return commentService.insertComment(commentVO);
	}
	
	@RequestMapping(value="/comment/{id}",method=RequestMethod.PUT)
	public int modifyComment(@RequestBody CommentVO commentVO) {
		return commentService.updateComment(commentVO);
	}
	@RequestMapping(value="/comment/{id}",method=RequestMethod.DELETE)
	public int deleteComment(@PathVariable int id) {
		return commentService.deleteComment(id);
	}
	
}
