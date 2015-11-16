package com.yapp.urlshorter.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yapp.urlshorter.entity.Url;
import com.yapp.urlshorter.entity.User;
import com.yapp.urlshorter.exception.BadRequestException;
import com.yapp.urlshorter.exception.NoUrlException;
import com.yapp.urlshorter.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {
	public static final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);
	
	@Autowired UrlRepository urlRepository;
	
	public List<Url> getUrls(long userId) {
		List<Url> urls = urlRepository.findUrlByUserId(userId);
		logger.info(urls.toString());
		return urls;
	}
	
	public int addUrl(String url, long userId) {
		return urlRepository.save(url, userId);
	}
	
	/**
	 * URL의 ID로 하나의 URL 정보 조회
	 * @param id URL ID
	 * @return {@link Url}
	 */
	public Url getUrl(long id) {
		return urlRepository.findUrlById(id);
	}
	
	
	public Url redirectToOriginalUrl(long id) {
		Url url = urlRepository.findUrlById(id);
		
		if (null == url) {
			throw new NoUrlException();
		} 
			
		urlRepository.increaseCount(id);
		return url;
	}

	@Override
	public void deleteUrl(long id, User user) {
		// user와 url의 user_id가 동일한지 확인
		
		Url url = urlRepository.findUrlById(id);
		
		if (user.getId() != url.getUserId()) throw new BadRequestException();
		
		urlRepository.deleteOne(id);
	}
}
