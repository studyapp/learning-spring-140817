package com.yapp.urlshorter.repository;

import com.yapp.urlshorter.entity.User;

public interface UserRepository {
	// ȸ������
	int save(User user);
	
	// ���̵�&�н����� Ȯ��
	User findUserByUsernameAndPassword(String username, String password);
	
	User findUserByUsername(String username);
}
