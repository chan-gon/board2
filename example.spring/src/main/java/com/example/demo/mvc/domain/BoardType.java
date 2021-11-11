package com.example.demo.mvc.domain;


/**
 * �Խ��� ����
 * @author ������
 *
 */
public enum BoardType implements BaseCodeLabelEnum {
	COMMUNITY("Ŀ�´�Ƽ"),
	NOTICE("��������"),
	FAQ("���ֹ��� ����"),
	INQUIRY("1:1����"),
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
