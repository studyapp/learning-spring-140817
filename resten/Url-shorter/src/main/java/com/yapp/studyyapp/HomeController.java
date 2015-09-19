package com.yapp.studyyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yapp.studyyapp.service.ShorterService;

/**
 * http://www.yapp.com/shorter /convert?url=http://..
 * 
 * http : scheme / protocol
 * 2차도메인.1차도메인.국가도메인	-> host
 *  /shorter/convert -> URI PATH
 *  	/shorter  -> application path
 *  	/convert  -> 실제적으로 매핑되는 url
 * Query String 
 */

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired	//DI
	//@Qualifier("default") 인터페이스 한정자
	private ShorterService shorterService;
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * 접속 하면 연결되는 페이지
	 */
	@RequestMapping(value="/home", 
			method=RequestMethod.GET)
			//params=
			//header= Accept:plain/text
			//consumes=	//서버가 받을수 있는 타입
			//produces= //제공 해 줄수 있는 타입
			
	public String getConvertPage(){
		//logger 로그 우선순위 레벨
			//trace
			//debug
			//info
			//warn
			//error			log level로 단계적 확인 가능
			logger.info("request home");
	
			///반환하는 페이지 이름 (jsp 파일의 이름)
			return "convertPage";// convertPage.jsp
	}
	
	@RequestMapping(value="/convert",
			method=RequestMethod.POST)
	public String convert(@RequestParam("url") String url, ModelMap modelMap){
		String shortedUrl = shorterService.convert(url);
		logger.info("url:{}",url);
		modelMap.addAttribute("shortedUrl",shortedUrl);
		return "convertResult";
	}
	
}
