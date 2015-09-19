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
 * http://www.yapp.com/shorter  /convert?url=http://www.naver.com
 * 
 * http:scheme/protocol
 * 2차 도메인.1차도메인.국가도메인
 * ->Host
 * /shorter/convert/a/b/c->URI Path
 *shorter->application path
 *convert->
 *Query String
 *
 */ 

/**
 * Handles requests for the application home page.
 */
@Controller // 요청 가장먼저 받음
public class HomeController {
	@Autowired // di dependency관계 ingection
	private ShorterService shorterService;
	// {
	// ShorterService service=new ShorterServiceImpl();
	// }

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * 접속하면 뜰 페이지
	 */
	@RequestMapping(value = "/convert", method = RequestMethod.GET
	// param=//name
	// headers=//Accept:plan/text plan/html
	// consumes=//서버가 받을 수 있는 타입html
	// produces=//제공해줄수있는 타ㅏ입 html
	)
	public String getConvertPage() {
		// 우선순위1trace
		// 2debug
		// 3info
		// 4warn
		// 5error
		// log level=4.warning
		System.out.println("");
		logger.info("request home");
		return "convertpage";
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public String convert(@RequestParam("url") String url, ModelMap modelMap) {
		logger.info("url:{}", url);

		// url을 줄임
		String shortedUrl = shorterService.convert(url);
		modelMap.addAttribute("shortedUrl", shortedUrl);
		return "convertResult";
	}

}
