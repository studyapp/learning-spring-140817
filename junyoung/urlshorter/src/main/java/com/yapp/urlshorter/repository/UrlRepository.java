package com.yapp.urlshorter.repository;

import java.util.List;

import com.yapp.urlshorter.entity.Url;

public interface UrlRepository {
	// 등록
	int save(String url, long userId);
	
	// ID 원본 URL 확인
	Url findUrlById(long id);
	
	// 사용자의 전체 URL 목록
	List<Url> findUrlByUserId(long userId);

	// URL으로 접속 시 count 증가
	int increaseCount(long id);

	int deleteOne(long id);
}
