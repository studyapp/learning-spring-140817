package com.yapp.studyyapp.service;

import org.springframework.stereotype.Service;

import com.yapp.studyyapp.Base62;

@Service
public class ShorterServiceImpl implements ShorterService {
	int index=0;
	@Override
	public String convert(String url) {
		String shortedUrl = url+"short";
		index++;
		//db¿¡ ÀúÀå Integer ID (PK)
		//Integer -> Base62EncodedUrl
		shortedUrl =Base62.encode(index);
		
		return shortedUrl;
	}

}
