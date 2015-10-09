package com.yapp.studyapp.repository;

public class StaticInitBlock {
	// 동적 초기화 블럭 (Dynamic initialize block) 
	{
		System.out.println("동적 초기화 블럭");
	}
	
	// 정적 초기화 블럭
	static {
		System.out.println("정적 초기화 블럭 실행");
	}
	
	// Static method
	public static void print() {
		System.out.println("하잉");
	}
}
