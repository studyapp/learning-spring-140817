package com.yapp.studyyapp;

public class Base62 {

	private static final  String TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz"
			+ "0123456789";
	private static final int BASE = TABLE.length();
	
	public static String encode(int input){
		StringBuilder builder = new StringBuilder("");
		while(input>0){
			int index = input%BASE;
			input = input/BASE;
			builder.append(TABLE.charAt(index));
		}
		String result = builder.reverse().toString();
		return result;
	}
	
	public static int decode(String input){
		StringBuilder builder = new StringBuilder(input);
		builder.reverse();
		int result=0;
		for(int i=0; i<input.length();i++){
			char ch = builder.charAt(i);
			int number =TABLE.indexOf(ch);
			
			if(number <0){
					throw new IllegalInputException();
			}
			result+=number * Math.pow(BASE, i);
		}
		return result;
	}
}
