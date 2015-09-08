package org.dataapproach.simple.teasers.misc;

import java.util.Scanner;

/**
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet. For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * 
 * This problem is the reverse version of Excel Sheet Column Number.
 * 
 * The key is n--. The minimum in 26-bit number is mapped to 1, not 0.
 * 
 * @author sarath
 *
 */
public class ExcelColumnNumberToTitle {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input column #:");
		long x = in.nextLong();

		System.out.println("Corresponding Column tiltle :"
				+ ExcelColumnNumberToTitle.convertToTitle(x));

	}

	public static String convertToTitle(long n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}

}
