package com.example.demo.mvc.domain;

/**
 * 메뉴 게시판 종류
 * @author 김찬곤
 *
 */
public enum MenuType{
	
	community(BoardType.community),
	notice(BoardType.notice),
	faq(BoardType.faq),
	inquiry(BoardType.inquiry),
	;
	
	private BoardType boardType;
	
	MenuType(BoardType boardType) {
		this.boardType = boardType;
	}

	public BoardType boardType() {
		return boardType;
	}
	
}
