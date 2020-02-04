package com.young.web.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.young.web.board.dao.BoardDAO;
import com.young.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDAO.insertBoard(boardVO);
	}

}
