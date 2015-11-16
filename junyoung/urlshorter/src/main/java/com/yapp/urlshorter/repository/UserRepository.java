package com.yapp.urlshorter.repository;

import com.yapp.urlshorter.entity.User;

public interface UserRepository {
	// 회원가입
	int save(User user);
	
	// 아이디&패스워드 확인
	User findUserByUsernameAndPassword(String username, String password);
	
	User findUserByUsername(String username);
}
