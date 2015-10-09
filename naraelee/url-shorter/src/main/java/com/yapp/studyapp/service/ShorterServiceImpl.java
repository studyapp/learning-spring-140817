package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

import com.yapp.studyapp.Base62;

//Convention 이름 정할때하는 일반적 약속 

@Service
public class ShorterServiceImpl implements ShorterService{

	int index = 0;
	@Override
	public String convert(String url) {
		String shortedUrl = url + "줄임!";
		index++;
		//DB에 url 저장 - Integer ID (PK)
		
		//Integer -> Base62encodedUrl
		shortedUrl = Base62.encode(Integer.parseInt(url));
		//변환된 값 반환 
		int url_check = Base62.decode(shortedUrl);
		return shortedUrl + ", input URL: " + url_check;
	}
	
}
