package com.yapp.urlshorter.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yapp.urlshorter.entity.User;
import com.yapp.urlshorter.service.UserService;

@Controller
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserService userService;
	
	// 로그인 페이지
	@RequestMapping("/login")
	public String getLoginPage(HttpSession session) {
		logger.info("로그인 페이지 접속");
		
		User user = (User)session.getAttribute("user");
		
		// 로그인 되어있는 상태라면 url 페이지로, 아니면 로그인 페이지로 이동
		return user == null ? "login" : "redirect:urls";
	}
		
	// 로그인 처리(POST)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelMap modelMap, HttpSession httpSession) {
		logger.info("로그인 요청 : {}, {}", username, password);
		
		User user = userService.login(username, password);
		logger.info("사용자 확인 : {}", user);
		if (user == null) {
			// 로그인 실패
			String errorMessage = "아이디 또는 패스워드가 일치하지 않습니다.";
			modelMap.put("errorMessage", errorMessage);
			return "login";
		} else {
			httpSession.setAttribute("user", user);
			return "redirect:urls";
		}
	}
	
	@RequestMapping("/sign-up")
	public String getSignUpPage() {
		return "signup";
	}
	
	@RequestMapping(value="/sign-up", method=RequestMethod.POST)
	public String signUp(@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelMap modelMap) {
		int result = userService.signUp(username, password);
		
		// 회원 가입이 정상적으로 처리된 경우
		if (result == 1) {
			return "completed";
		}
		
		String errorMessage = "";
		if (result == -1) {
			errorMessage = "이미 사용 중인 username입니다. 다른 username을 입력해 주세요.";
		} else {
			errorMessage = "회원가입을 할 수 없습니다. 관리자에게 문의해 주시기 바랍니다.";
		}
		
		modelMap.put("errorMessage", errorMessage);
		return "signup";
	}
}
