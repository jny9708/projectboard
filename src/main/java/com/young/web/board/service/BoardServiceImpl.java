package com.young.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.young.web.board.dao.BoardDAO;
import com.young.web.board.model.BoardVO;
import com.young.web.common.Pagination;
import com.young.web.common.XSSProtection;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public int insertBoard(BoardVO boardVO) {
		
		XSSProtection XSSProtection = new XSSProtection();
		boardVO.setContent(XSSProtection.replaceParameter(boardVO.getContent()));
		boardVO.setTitle(XSSProtection.replaceParameter(boardVO.getTitle()));
		return boardDAO.insertBoard(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(Pagination pagination) {
		return boardDAO.getBoardList(pagination);
	}

	@Override
	public BoardVO getBoardDetail(int id) {
		return boardDAO.getBoardDetail(id);
	}

	@Override
	public int deleteBoard(int id) {
		return boardDAO.deleteBoard(id);
	}

	@Override
	public int getTotalBoardCnt() {
		return boardDAO.getTotalBoardCnt();
	}

	@Override
	public int addViewCnt(int id) {
		return boardDAO.addViewCnt(id);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		XSSProtection XSSProtection = new XSSProtection();
		boardVO.setContent(XSSProtection.replaceParameter(boardVO.getContent()));
		boardVO.setTitle(XSSProtection.replaceParameter(boardVO.getTitle()));
		return boardDAO.updateBoard(boardVO);
	}

}
