/**
 * 
 */
package org.dataapproach.simple.teasers.math;

import java.util.Scanner;

/**
 * 
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * 
 * The key to solve this problem is multiplying each digit of the numbers at the
 * corresponding positions and get the sum values at each position. That is how
 * we do multiplication manually.
 * 
 * @author sarath
 *
 */
public class MultiplyTwoStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("String1 Input:");
		String x = in.next();

		System.out.println("String2 Input:");
		String y = in.next();

		System.out.println("MultiplyTwoStrings :"
				+ MultiplyTwoStrings.multiply(x, y));

	}

	public static String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		// multiply each digit and sum at the corresponding positions
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();

		// calculate each digit
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, mod);
		}

		// remove front 0's
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
