package com.yapp.urlshorter.exception;

/**
 * URL이 존재하지 않을 때 발생하는 예외 클래스
 */
public class NoUrlException extends RuntimeException {
	private static final long serialVersionUID = -1219331509418595398L;
	
	public NoUrlException() {
		super("URL이 없쪙..");
	}
}
