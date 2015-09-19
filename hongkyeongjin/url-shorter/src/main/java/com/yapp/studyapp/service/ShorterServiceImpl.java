package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

@Service
public class ShorterServiceImpl  implements ShorterService{
//int index=443435;
	@Override
	public String convert(String url) {
		String shortedUrl=url+"줄일거임";

		
		//db�� ����-integer id(pk)
		//integer->base62encodedUrl
		//��ȯ
		
		return shortedUrl;
	}

}
