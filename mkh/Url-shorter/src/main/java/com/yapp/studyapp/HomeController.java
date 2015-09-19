package com.yapp.studyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yapp.studyapp.service.ShorterService;

/**
 * http://www.yapp.com/shorter /convert?url=http://www.naver.com#
 * 2�� ������, 1�� ������, ����������
 * -> Host
 * shorter/convert ->uri path
 * shorter -> application path
 * convert -> 
 * Query String
 */
@Controller
public class HomeController {
	
	@Autowired //DI Dependency(����) Injection
	private ShorterService shorterService;
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*
	 * ����������
	 */
	@RequestMapping(value="/convert", method=RequestMethod.GET)
//			param=// name
//			header= //Ŭ���̾�Ʈ html
//			consume= //������ ���� �� �ִ� Ÿ�� html
//			produces=//������ �ټ� �ִ� Ÿ��html
	public String getConvertPage(){  
		// 1.trace, 2.debug, 3.info, 4.worn, 5.error
		logger.info("request home");
		
		// ��ȯ�ϴ� ������ �̸�
		return "convertPage"; 
	}
	
	@RequestMapping(value="/convert", method=RequestMethod.POST)
	public String convert(@RequestParam("url") String url,
			ModelMap modelMap){
		
		logger.info("url : {}",url);
		
		// url�� ����
		
	
		String shortedUrl=shorterService.convert(url);
		modelMap.addAttribute("shortedUrl",shortedUrl);
		
		return "convertResult";
	}
}
