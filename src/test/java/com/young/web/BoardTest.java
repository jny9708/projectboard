package com.young.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.web.board.dao.BoardDAO;
import com.young.web.board.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml","classpath:spring/data-context.xml","classpath:spring/security-context.xml"})
public class BoardTest {
	
	@Inject
	SqlSessionTemplate sqlsession;
	
	@Inject
	BoardDAO boardDAO;
	
	@Test
	public void insertBoard() {
		BoardVO boardVO = new BoardVO();
		for(int i =5; i<10; i++) {
			boardVO.setTitle(i+"번째 게시물입니다.");
			boardVO.setContent(i+"번째 게시물 내용입니다.");
			boardVO.setMember_id(1);
			boardDAO.insertBoard(boardVO);
		}
		
		
		
		
		
	}
	
}
