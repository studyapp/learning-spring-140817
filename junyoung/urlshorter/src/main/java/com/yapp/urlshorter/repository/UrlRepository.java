package com.yapp.urlshorter.repository;

import java.util.List;

import com.yapp.urlshorter.entity.Url;

public interface UrlRepository {
	// ���
	int save(String url, long userId);
	
	// ID ���� URL Ȯ��
	Url findUrlById(long id);
	
	// ������� ��ü URL ���
	List<Url> findUrlByUserId(long userId);

	// URL���� ���� �� count ����
	int increaseCount(long id);

	int deleteOne(long id);
}
