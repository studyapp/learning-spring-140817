package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

// Convention 
@Service
public class ShorterServiceImpl implements ShorterService{
	int index=98231;
	@Override
	public String convert(String url) {
		String shortedUrl=url + "이거 줄일거임";
		index++; //실제로는 db인덱스 값이 올라감
		Base62 base=new Base62();
		shortedUrl=base.fromBase10(index);
		//DB에 저장 - Integer Id(PK)
		
		//integer -> Base62encodedUrl
		
		// 반환
		
		return shortedUrl;
	}
}
