package com.young.web.board.service;

import java.util.List;

import com.young.web.board.model.BoardVO;
import com.young.web.common.Pagination;

public interface BoardService {
	public int insertBoard(BoardVO boardVO);
	public List<BoardVO> getBoardList(Pagination pagination);
	public BoardVO getBoardDetail(int id);
	public int deleteBoard(int id);
	public int getTotalBoardCnt();
	public int addViewCnt(int id);
	public int updateBoard(BoardVO boardVO);
}
