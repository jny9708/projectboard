package com.young.web.comment.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.young.web.comment.dao.CommentDAO;
import com.young.web.comment.model.CommentVO;
import com.young.web.common.XSSProtection;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	CommentDAO commentDAO;

	@Override
	public int insertComment(CommentVO commentVO) {
		XSSProtection XSSProtection = new XSSProtection();
		commentVO.setContent(XSSProtection.replaceParameter(commentVO.getContent()));
		return commentDAO.insertComment(commentVO); 
	}

	@Override
	public List<CommentVO> getCommentList(int id) {
		return commentDAO.getCommentList(id);
	}

	@Override
	public int updateComment(CommentVO commentVO) {
		XSSProtection XSSProtection = new XSSProtection();
		commentVO.setContent(XSSProtection.replaceParameter(commentVO.getContent()));
		return commentDAO.updateComment(commentVO);
	}

	@Override
	public int deleteComment(int id) {
		return commentDAO.deleteComment(id);
	}
	
	

}
