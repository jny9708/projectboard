package com.young.web.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.young.web.board.model.BoardVO;
import com.young.web.board.service.BoardService;
import com.young.web.common.Pagination;

@Controller
public class BoardController {

	@Inject
	BoardService boardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardList(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			HttpServletRequest request) {
		int totalBoardCnt = boardService.getTotalBoardCnt();
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, totalBoardCnt);
		List<BoardVO> boardList = boardService.getBoardList(pagination);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagination", pagination);

		return "/board/boardList";
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWritePage() {
		return "/board/boardWrite";
	}

	@RequestMapping(value = "/board/add", method = RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getBoard(@PathVariable int id, Model model, HttpServletRequest request,
			HttpServletResponse response) {

//		Cookie[] cookies = request.getCookies();
//		if(cookies!=null) {
//			for(Cookie c : cookies) {
//				if(c.getName().equals("board_id")) {
//					if(!(c.getValue().equals(Integer.toString(id))? true : false)) {
//						
//					}
//				}
//			}
//		}

//		if(cookie==null) {
//			String board_id = Integer.toString(id);
//			Cookie newCookie = new Cookie("board_id"+board_id, true);
//			newCookie.setMaxAge(60*60*24);
//			
//			response.addCookie(newCookie);
//		}

		boardService.addViewCnt(id);
		BoardVO boardVO = boardService.getBoardDetail(id);
		model.addAttribute("boardVO", boardVO);
		return "/board/boardDetail";
	}

	@RequestMapping(value = "board/delete/{id}", method = RequestMethod.GET)
	public String deleteBoard(@PathVariable int id, RedirectAttributes redirect) {
		int result = boardService.deleteBoard(id);
		if (result > 0) {
			redirect.addFlashAttribute("msgs", "게시글을 삭제하였습니다.");
		} else {
			redirect.addFlashAttribute("msgs", "게시글 삭제에 실패하였습니다.");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "board/modify/{id}", method = RequestMethod.GET)
	public String modifyBoardpage(@PathVariable int id, Model model) {
		boolean modify = true;
		BoardVO boardVO = boardService.getBoardDetail(id);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("modify", modify);
		return "/board/boardWrite";
	}

	@RequestMapping(value = "board/modify", method = RequestMethod.POST)
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:/" + boardVO.getId();
	}

}
