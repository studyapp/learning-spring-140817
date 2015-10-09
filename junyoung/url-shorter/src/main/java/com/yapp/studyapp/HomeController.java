package com.yapp.studyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yapp.studyapp.service.ShorterService;
import com.yapp.studyapp.service.ShorterServiceImpl;

/**
 * http://www.yapp.com/shorter  /convert?url=http://www.naver.com#
 * 
 * http : scheme / protocol
 * 2차 도메인.1차도메인.국가도메인
 *  -> Host
 * /shorter/convert/a/b/c/ -> URI Path
 * shorter -> application path
 * convert -> 
 * Query String
 * 
 */





/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired // DI Dependency(관계) Injection
	@Qualifier("defaultShorterService")
	private ShorterService shorterService;

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 접속하면 뜰 페이지
	 */
	@RequestMapping(value="/convert", method=RequestMethod.GET)
//			param= // name
//			headers= // Accept:plan/text plan/html
//			consumes= // 서버가 받을 수 있는 타입 html
//			produces= // 제공해줄 수 있는 타입 html)
	public String getConvertPage() {  // home
		// 1. trace
		// 2. debug
		// 3. info
		// 4. warn
		// 5. error
		// log level = 4.warning
		logger.info("request home");
		
		// 반환하는 페이지 이름 (jsp 파일의 이름)
		return "convertPage"; // convertPage.jsp
	}
	
	@RequestMapping(value="/convert", method=RequestMethod.POST)
	public String convert(@RequestParam("url") String url,
			ModelMap modelMap) {
		logger.info("url : {}", url);
		
		String shortedUrl = shorterService.convert(url); //url + "이거 줄일거임";
		
		modelMap.addAttribute("shortedUrl", shortedUrl);
		
		return "convertResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
