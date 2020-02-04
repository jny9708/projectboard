package com.young.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.young.web.board.model.BoardVO;
import com.young.web.board.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardList() {
		
		return "/board/boardList";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWritePage() {
		
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/board/add",method=RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) {
		
		boardService.insertBoard(boardVO);
		
		return "/";
	}

	
}
