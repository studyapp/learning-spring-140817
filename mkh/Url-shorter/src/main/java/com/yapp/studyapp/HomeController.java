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
 * 2차 도메인, 1차 도메인, 국가도메인
 * -> Host
 * shorter/convert ->uri path
 * shorter -> application path
 * convert -> 
 * Query String
 */
@Controller
public class HomeController {
	
	@Autowired //DI Dependency(관계) Injection
	private ShorterService shorterService;
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*
	 * 페이지접속
	 */
	@RequestMapping(value="/convert", method=RequestMethod.GET)
//			param=// name
//			header= //클라이언트 html
//			consume= //서버가 받을 수 있는 타입 html
//			produces=//제공해 줄수 있는 타입html
	public String getConvertPage(){  
		// 1.trace, 2.debug, 3.info, 4.worn, 5.error
		logger.info("request home");
		
		// 반환하는 페이지 이름
		return "convertPage"; 
	}
	
	@RequestMapping(value="/convert", method=RequestMethod.POST)
	public String convert(@RequestParam("url") String url,
			ModelMap modelMap){
		
		logger.info("url : {}",url);
		
		// url을 줄임
		
	
		String shortedUrl=shorterService.convert(url);
		modelMap.addAttribute("shortedUrl",shortedUrl);
		
		return "convertResult";
	}
}
