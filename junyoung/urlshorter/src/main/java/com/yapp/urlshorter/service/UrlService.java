package com.yapp.urlshorter.service;

import java.util.List;

import com.yapp.urlshorter.entity.Url;
import com.yapp.urlshorter.entity.User;

public interface UrlService {
	public List<Url> getUrls(long userId);
	
	public int addUrl(String url, long userId);;
	
	public Url getUrl(long id);
	
	public Url redirectToOriginalUrl(long id);

	public void deleteUrl(long id, User user);
}
