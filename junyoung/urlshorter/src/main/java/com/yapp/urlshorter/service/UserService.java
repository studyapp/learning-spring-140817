package com.yapp.urlshorter.service;

import com.yapp.urlshorter.entity.User;

public interface UserService {
	// ȸ�� ����
	int signUp(String username, String password);
	
	// ���̵� ���� ���� Ȯ��(ȸ�� ���Զ� �ߺ� üũ)
	
	// �α���
	User login(String username, String password);
}
