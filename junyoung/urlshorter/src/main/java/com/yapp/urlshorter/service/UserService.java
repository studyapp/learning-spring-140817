package com.yapp.urlshorter.service;

import com.yapp.urlshorter.entity.User;

public interface UserService {
	// 회원 가입
	int signUp(String username, String password);
	
	// 아이디 존재 여부 확인(회원 가입때 중복 체크)
	
	// 로그인
	User login(String username, String password);
}
