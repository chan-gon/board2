package com.example.demo.mvc.domain;

/**
 * �޴� �Խ��� ����
 * @author ������
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
