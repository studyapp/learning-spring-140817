package com.yapp.urlshorter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yapp.urlshorter.entity.Url;
import com.yapp.urlshorter.entity.User;
import com.yapp.urlshorter.exception.BadRequestException;
import com.yapp.urlshorter.exception.NoUrlException;
import com.yapp.urlshorter.service.UrlService;

@Controller
public class UrlController {
	public static final Logger logger = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired UrlService urlService;
	
	@RequestMapping("/urls")
	public String getUrlPage(HttpSession session, ModelMap modelMap) {
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			return "redirect:login";
		} else {
			// ����ڰ� ����� url ����� ��ȸ
			List<Url> urls = urlService.getUrls(user.getId());
			
			modelMap.put("urls", urls);
			
			return "urls";
		}
	}
	
	/**
	 * ���� URL ���
	 */
	@RequestMapping(value="/urls", method=RequestMethod.POST)
	public String addShortUrl(@RequestParam("url") String url,
			HttpSession session,
			ModelMap modelMap) {
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			return "redirect:login";
		} else {
			// ���� URL ����
			urlService.addUrl(url, user.getId());
			
			// ����ڰ� ����� url ����� ��ȸ
			List<Url> urls = urlService.getUrls(user.getId());
			
			logger.info(urls.toString());
			modelMap.put("urls", urls);
			
			return "redirect:urls";
		}
	}
	
	/**
	 * ���� URL�� ���� �����ϸ� Redirect�ϱ�
	 */
	@RequestMapping("/s/{id}")
	public String redirectToOriginalUrl(@PathVariable("id") long id) {
		Url url = urlService.redirectToOriginalUrl(id);
		
		return "redirect:" + url.getUrl();
	}
	
	@RequestMapping(value="/urls/delete", params="id")
	public String deleteUrl(@RequestParam("id") long id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		logger.info("�α��� ����� : {}", user);
		
		if (user == null) {
			return "redirect:login";
		} 
		
		urlService.deleteUrl(id, user);
		
		return "redirect:/urls";
	}
	
	
	@ExceptionHandler(NoUrlException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public void handleNoUrlException() {}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBadRequest(BadRequestException ex) {
		return "bad-request";
	}
}
