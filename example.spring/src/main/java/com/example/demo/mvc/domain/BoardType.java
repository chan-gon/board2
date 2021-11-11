package com.example.demo.mvc.domain;


/**
 * 게시판 종류
 * @author 김찬곤
 *
 */
public enum BoardType implements BaseCodeLabelEnum {
	community("커뮤니티"),
	notice("공지사항"),
	faq("자주묻는 질문"),
	inquiry("1:1문의"),
	;
	
	private String code;
	private String label;
	
	private BoardType(String label) {
		this.code = name();
		this.label = label;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public String label() {
		return label;
	}

}
