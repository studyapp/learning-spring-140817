package com.yapp.studyapp;

public class Base62 {
	private static final String base62 = "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String encode(int num) {
		int index = 0;
		int temp = num;

		StringBuilder builder = new StringBuilder();

		while (temp > 0) {
			index = temp % 62;
			temp = temp / 62;

			builder.append(base62.charAt(index));
		}

		return builder.reverse().toString();
	}

	public static int decode(String code) {
		StringBuilder builder2 = new StringBuilder(code);

		String str = builder2.reverse().toString();

		int v = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			int index = base62.indexOf(c);

			v = v + (index * (int) Math.pow(62, i));
		}
		return v;
	}
}
