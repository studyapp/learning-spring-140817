package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

@Service("shorterService")
public class ShorterServiceImpl implements ShorterService {
	int index = 983128;
	
	@Override
	public String convert(String url) {
		String shortedUrl = url + "�̰� ���ϰ���";
		index++; // �����δ� DB �ε��� ���� �ö�
		
		// DB�� ���� - Integer ID (PK)
		
		// integer -> Base62encodedUrl
		
		// ��ȯ
		return shortedUrl;
	}
}
