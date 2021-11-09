package com.example.demo.configuration.exception;

import com.example.demo.configuration.http.BaseResponseCode;

/**
 * 발생 가능성이 있는 예외에 대해 미리 추상 클래스를 생성하여 상황에 맞게 클래스를 상속하여 예외 처리 구현하면 괜찮다.
 * @author gon
 *
 */
public abstract class AbstractBaseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8342235231880246631L;
	
	protected BaseResponseCode responseCode;
	protected Object[] args;
	
	public AbstractBaseException() {
	}

	public AbstractBaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public BaseResponseCode getResponseCode() {
		return responseCode;
	}

	public Object[] getArgs() {
		return args;
	}
}
