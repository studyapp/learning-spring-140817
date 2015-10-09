package com.yapp.studyyapp.repository;

public class StaticInitBlock {
	

	///동적 초기화 블럭
	{
		System.out.println("동적 초기화 블럭 실행");
	}

	/// 정적 초기화 블럭
	static {
		System.out.println("정적 초기화 블럭 실행");
	}

	public static void print(){
		System.out.println("Call");
	}
	
	
}
