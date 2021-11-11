package com.example.demo.mvc.domain;

/**
 * �޴� �Խ��� ����
 * @author ������
 *
 */
public enum MenuType{
	
	community(BoardType.COMMUNITY),
	notice(BoardType.NOTICE),
	faq(BoardType.FAQ),
	inquiry(BoardType.INQUIRY),
	;
	
	private BoardType boardType;
	
	MenuType(BoardType boardType) {
		this.boardType = boardType;
	}

}
