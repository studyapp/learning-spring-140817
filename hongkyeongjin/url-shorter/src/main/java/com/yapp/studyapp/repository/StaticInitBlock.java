package com.yapp.studyapp.repository;

public class StaticInitBlock {
	public static final String TEST="test";
	private String name;
//동적초기화 블럭
	{
		System.out.println("동적초기화블록");
		
	}
	static{
		System.out.println("정적초기화 블럭 실행");
	}
	//static method
	public static void print(){
		System.out.println("하잉");
	}
}
