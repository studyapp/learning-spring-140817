package com.yapp.studyapp.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.yapp.studyapp.model.Base62;

//Convention 관례를 잘지키면서 프로그래밍 하면 남들이 코드 읽기가 좋다.

@Service("shorter")
public class ShorterServiceImpl implements ShorterService {

	int index = 0;
	// a64

	@Override
	public String convert(String url) {

		String shortedUrl = url + "-short_url";
		index++;

		// index - Base62 - 인코딩한다!

		Base62 base62 = new Base62();

		if (isStringDouble(url)) {
			shortedUrl = base62.encodeBase10(Integer.valueOf(url));
		} else {
			
			boolean d = Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", url);
			if(d){
				shortedUrl = "url이 한글!";
			}
			else{
				base62.decodeBase62(url);
				shortedUrl = "url 이 숫자가 아님";
			}
		}


		// TODO Auto-generated method stub
		// DB 저장 - Integer ID(PK)

		// Integer -> Base62encodedUrl

		// 반환
		return shortedUrl;
	}

	public boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
