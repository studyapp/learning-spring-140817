package com.yapp.studyapp.repository;

public class StaticInitBlock {
	//동적 초기화 블록
	{
		System.out.println("동적초기화블록 실행 ");
	}
	
	//정적 초기화 블록
	static {
		System.out.println("정적초기화블록 실행 ");
	}
	
	public static void print(){
		System.out.println("hiho! :) ");
	}
}
