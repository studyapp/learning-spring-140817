package com.yapp.studyapp;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yapp.studyapp.model.Base62;
import com.yapp.studyapp.service.ShorterService;

@Controller
public class HomeController {
	
	//DI(Dependency Injection - 의존성(관계) 주입)
	@Autowired
	@Qualifier("shorter")//서비스가 중복될시 이름을 정해주고 추가해준다!
	private ShorterService shorterService;
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//접속하면 틀 페이지
	@RequestMapping(value = "/convert" 
			, method = RequestMethod.GET )
			/*, params = 파라미터들
			, header = Accept:plain/text plain/html
			, consumes = 서버가 받을 수 있는 타입
			, produces = 제공해 줄수 있는 타입)*/
	public String getConvertPage(){
		
		
		/*
		 * RequestMapping
		 * 
		 * http://www.naver.com/shorter/convert?url=http://www.naver.com
		 * 
		 * http : 스키마/프로토콜
		 * 2차 도메인.1차 도메인.국가 도메인
		 * 
		 *     ///shorter/convert -> URI path
		 *     shorter -> application path
		 *     convert
		 *     ? -> QueryString
		 *     # -> Hash
		 *     
		 *     		
		 */
		
		// trace > debug > info > warn > error
		// log level -> warning 이라고하면 그 이하의 로그는 남지 않는다.
		
		
		
		logger.info("request home");
		
		//반환하는 jsp파일의 이름을 명시해주면 찾아서감!
		return "convertPage";
		
	}
	
	
	
	@RequestMapping(value = "/convert" 
			, method = RequestMethod.POST )
	public String convert(@RequestParam("url")String url, ModelMap modelMap){
		
		String url2 = null;
		try {
			url2 = new String(url.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("url : {}",url2);
		
		
		
		//url을 줄임!
		String shortedUrl = shorterService.convert(url2);
//		shortedUrl.setCharacterEncoding("utf-8") 	.
		
		modelMap.addAttribute("shortedUrl",shortedUrl);
		return "convertResult";
	}
	
	
	
	//web.xml -> 서블릿설정
	//servlet-context.xml -> spring 설정을 하는 것!
	
}
