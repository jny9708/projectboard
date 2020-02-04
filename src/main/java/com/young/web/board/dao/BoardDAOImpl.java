package com.young.web.board.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.young.web.board.model.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private String namespace = "com.young.web.board";
	
	@Inject
	SqlSessionTemplate sqlsession;

	@Override
	public int insertBoard(BoardVO boardVO) {
		return sqlsession.insert(namespace + ".insertBoard", boardVO);
	}
	
	

}
