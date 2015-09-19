package com.yapp.studyapp.service;

public class Base62 {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static final int BASE = ALPHABET.length();

	public Base62() {}

	public static String fromBase10(int i) {
		StringBuilder sb = new StringBuilder("");
		while (i > 0) {
			i = fromBase10(i, sb);
		}
		return sb.reverse().toString();
	}

	private static int fromBase10(int i, final StringBuilder sb) {
		int rem = i % BASE;
		sb.append(ALPHABET.charAt(rem));
		return i / BASE;
	}

	}
