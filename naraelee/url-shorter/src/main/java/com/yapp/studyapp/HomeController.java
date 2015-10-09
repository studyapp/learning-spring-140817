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

/**
*http://www.yapp.com/shorter /convert?url=http://www.naver.com
*http : schema / protocol
*2차 도메인.1차도메인.국가도메인
* ->HOST
* shorter -> application path
* convert
*     ? -> QueryString
*     # -> Hash
*/

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired //Dependency Injection (관계)
	//구현 클래스가 여러개일때 , service("") value를 넣어주고
	//@Qualifier("")를 함께 선언해준다!
	private ShorterService shorterService;
	// == ShorterService service = new ShorterServiceImpl();
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/convert", method = RequestMethod.GET)
	public String getConvertPage() {
		// log level
		// 1.trace
		// 2.debug
		// 3.info
		// 4.warn
		// 5.error
		// log level = 4.warn 이면 123은 무시됨.

		logger.info("request home");

		// 반환하는 jsp파일의 이름을 명시해주면 찾아서감!
		return "convertpage"; // converpage.jsp 반환
	}
	
	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public String convert(@RequestParam("url") String url, ModelMap modelMap){
		
		logger.info("url : {} ", url); //%d %s 이런거 한번에 묶는게 대괄호
		
		//url 을 줄임
		
		
		
		String shortedUrl = shorterService.convert(url); // url +"줄일거얍"
		
		modelMap.addAttribute("shortedUrl", shortedUrl);
		
		return "convertResult";
	}
	
	
	
	public static int decode(String text){
		StringBuilder builder = new StringBuilder(text);
		
		String s = builder.reverse().toString();
		
		
		return -1;
	}
}
