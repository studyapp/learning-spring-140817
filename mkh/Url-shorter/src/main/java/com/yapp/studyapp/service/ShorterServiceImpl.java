package com.yapp.studyapp.service;

import org.springframework.stereotype.Service;

// Convention 
@Service
public class ShorterServiceImpl implements ShorterService{
	int index=98231;
	@Override
	public String convert(String url) {
		String shortedUrl=url + "�̰� ���ϰ���";
		index++; //�����δ� db�ε��� ���� �ö�
		Base62 base=new Base62();
		shortedUrl=base.fromBase10(index);
		//DB�� ���� - Integer Id(PK)
		
		//integer -> Base62encodedUrl
		
		// ��ȯ
		
		return shortedUrl;
	}
}
