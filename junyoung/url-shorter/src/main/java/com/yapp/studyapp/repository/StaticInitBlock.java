package com.yapp.studyapp.repository;

public class StaticInitBlock {
	// ���� �ʱ�ȭ �� (Dynamic initialize block) 
	{
		System.out.println("���� �ʱ�ȭ ��");
	}
	
	// ���� �ʱ�ȭ ��
	static {
		System.out.println("���� �ʱ�ȭ �� ����");
	}
	
	// Static method
	public static void print() {
		System.out.println("����");
	}
}
