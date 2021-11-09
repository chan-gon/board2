package com.example.demo.configuration.http;

import lombok.Data;

/**
 * 공통으로 사용할 응답 클래스
 * @author 김찬곤
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> {
	
	private BaseResponseCode code;
	private String message;
	private T data;
	
	
//	성공 시 사용되는 생성자
	public BaseResponse(T data) {
		this.code = BaseResponseCode.SUCCESS;
		this.data = data;
	}

//	예외 발생 시 사용되는 생성자
	public BaseResponse(BaseResponseCode code, String message) {
		this.code = code;
		this.message = message;
	}
}
