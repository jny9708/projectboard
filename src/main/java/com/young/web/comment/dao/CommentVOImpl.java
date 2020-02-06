package com.young.web.comment.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.young.web.comment.model.CommentVO;

@Repository
public class CommentVOImpl implements CommentDAO {

	private String namespace = "com.young.web.comment";
	
	@Inject
	SqlSessionTemplate sqlsession;
	
	@Override
	public int insertComment(CommentVO commentVO) {
		return sqlsession.insert(namespace + ".insertComment",commentVO);
	}

	@Override
	public List<CommentVO> getCommentList(int id) {
		return sqlsession.selectList(namespace + ".getCommentList", id);
	}

	@Override
	public int updateComment(CommentVO commentVO) {
		return sqlsession.update(namespace + ".updateComment", commentVO);
	}

	@Override
	public int deleteComment(int id) {
		return sqlsession.delete(namespace + ".deleteComment",id);
	}


}
