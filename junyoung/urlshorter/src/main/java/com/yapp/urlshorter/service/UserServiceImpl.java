package com.yapp.urlshorter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yapp.urlshorter.entity.User;
import com.yapp.urlshorter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired UserRepository userRepository;

	@Override
	public int signUp(String username, String password) {
		// ID 중복 체크 - 회원 가입 시 입력한 username으로 사용자 조회
		User existUser = userRepository.findUserByUsername(username);
		
		if (null == existUser) {
			User user = new User(username, password);
			return userRepository.save(user);
		} else {
			return -1;
		}
	}

	@Override
	public User login(String username, String password) {
		logger.info("login process {} {}", username, password);
		User user = userRepository.findUserByUsernameAndPassword(username, password);
		
		return user;
	}
	
	
}
