package com.example.demo.configuration.http;

import lombok.Data;

/**
 * �������� ����� ���� Ŭ����
 * @author ������
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> {
	
	private BaseResponseCode code;
	private String message;
	private T data;
	
	
//	���� �� ���Ǵ� ������
	public BaseResponse(T data) {
		this.code = BaseResponseCode.SUCCESS;
		this.data = data;
	}

//	���� �߻� �� ���Ǵ� ������
	public BaseResponse(BaseResponseCode code, String message) {
		this.code = code;
		this.message = message;
	}
}
