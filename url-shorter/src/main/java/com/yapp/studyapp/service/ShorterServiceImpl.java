package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

@Service("shorterService")
public class ShorterServiceImpl implements ShorterService {
	int index = 983128;
	
	@Override
	public String convert(String url) {
		String shortedUrl = url + "이거 줄일거임";
		index++; // 실제로는 DB 인덱스 값이 올라감
		
		// DB에 저장 - Integer ID (PK)
		
		// integer -> Base62encodedUrl
		
		// 반환
		return shortedUrl;
	}
}
