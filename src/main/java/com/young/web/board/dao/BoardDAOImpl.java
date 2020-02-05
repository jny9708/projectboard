package com.young.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.young.web.board.model.BoardVO;
import com.young.web.common.Pagination;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private String namespace = "com.young.web.board";
	
	@Inject
	SqlSessionTemplate sqlsession;

	@Override
	public int insertBoard(BoardVO boardVO){
		return sqlsession.insert(namespace + ".insertBoard", boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(Pagination pagination) {
		return sqlsession.selectList(namespace + ".getBoardList",pagination);
	}

	@Override
	public BoardVO getBoardDetail(int id) {
		return sqlsession.selectOne(namespace + ".getBoardDetail",id);
	}

	@Override
	public int deleteBoard(int id) {
		return sqlsession.delete(namespace + ".deleteBoard", id);
	}

	@Override
	public int getTotalBoardCnt() {
		return sqlsession.selectOne(namespace + ".getTotalBoardCnt");
	}

	@Override
	public int addViewCnt(int id) {
		return sqlsession.update(namespace + ".addViewCnt", id);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlsession.update(namespace + ".updateBoard", boardVO);
	}
	
	

}
