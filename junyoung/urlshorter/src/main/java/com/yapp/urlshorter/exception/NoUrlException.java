package com.yapp.urlshorter.exception;

/**
 * URL�� �������� ���� �� �߻��ϴ� ���� Ŭ����
 */
public class NoUrlException extends RuntimeException {
	private static final long serialVersionUID = -1219331509418595398L;
	
	public NoUrlException() {
		super("URL�� ����..");
	}
}
