package com.sumy.tools;

import java.util.Random;

public class RandomString {
	/**
	 * ²úÉúËæ»ú×Ö·û´®
	 * */
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	private static char[] firstLetters = null;

	public static final String randomString(int length) {
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
			numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")
					.toCharArray();
			firstLetters = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char[] randBuffer = new char[length];
		randBuffer[0] = firstLetters[randGen.nextInt(25)];
		for (int i = 1; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
		}
		return new String(randBuffer);
	}
}
