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
	
	// �α��� ������
	@RequestMapping("/login")
	public String getLoginPage(HttpSession session) {
		logger.info("�α��� ������ ����");
		
		User user = (User)session.getAttribute("user");
		
		// �α��� �Ǿ��ִ� ���¶�� url ��������, �ƴϸ� �α��� �������� �̵�
		return user == null ? "login" : "redirect:urls";
	}
		
	// �α��� ó��(POST)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelMap modelMap, HttpSession httpSession) {
		logger.info("�α��� ��û : {}, {}", username, password);
		
		User user = userService.login(username, password);
		logger.info("����� Ȯ�� : {}", user);
		if (user == null) {
			// �α��� ����
			String errorMessage = "���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.";
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
		
		// ȸ�� ������ ���������� ó���� ���
		if (result == 1) {
			return "completed";
		}
		
		String errorMessage = "";
		if (result == -1) {
			errorMessage = "�̹� ��� ���� username�Դϴ�. �ٸ� username�� �Է��� �ּ���.";
		} else {
			errorMessage = "ȸ�������� �� �� �����ϴ�. �����ڿ��� ������ �ֽñ� �ٶ��ϴ�.";
		}
		
		modelMap.put("errorMessage", errorMessage);
		return "signup";
	}
}
