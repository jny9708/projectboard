package com.young.web.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pagination {

	private int perPageBoardNum = 10;                // 한 페이지당 보여질 게시물의 개수
	private int rangeSize = 5;            // 한 페이지 범위에 보여질 페이지의 개수
	private int page;					// 현재 목록의 페이지 번호
	private int totalBoardCnt;			// 전체 게시물 개수
	private int totalpageCnt;			// 전체 페이지수 
	private int startPage;				// 각 페이지 범위 시작 번호
	private int startBoardNum;			// 해당 페이지에 있는 제일 첫번째 게시물 번호 (시작번호) 
	private int endPage;				//각 페이지 범위(블럭) 끝 번호
	private boolean prev;				// 이전 페이지 활성화 여부
	private boolean next;				// 다음 페이지 활성화 여부

	public void pageInfo(int page, int totalBoardCnt) {

		this.page = page;
		
		this.totalBoardCnt = totalBoardCnt;

		//전체 페이지수 
		this.totalpageCnt = (int) Math.ceil((double)totalBoardCnt/perPageBoardNum);

		//시작 페이지
		this.startPage = ((page - 1) / rangeSize) * rangeSize + 1;

		
		//끝 페이지
		this.endPage =  startPage + rangeSize - 1;
		if(endPage>totalpageCnt) {
			this.endPage = totalpageCnt;
		}

		//게시판 시작번호
		this.startBoardNum = (page - 1) * perPageBoardNum;

		//이전 버튼 상태
		this.prev = startPage == 1 ? false : true;

		//다음 버튼 상태
		this.next = endPage >= totalpageCnt ? false : true;
		
	}
	
}
