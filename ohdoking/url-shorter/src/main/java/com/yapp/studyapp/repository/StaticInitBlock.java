package com.yapp.studyapp.repository;

public class StaticInitBlock {
	//���� �ʱ�ȭ ��
	{
		System.out.println("����!");
	}
	
	//���� �ʱ�ȭ ��
	static
	{
		System.out.println("����!");
	}
	
	public static void print(){
		System.out.println("static");
	}
}
