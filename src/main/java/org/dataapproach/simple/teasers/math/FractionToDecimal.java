package org.dataapproach.simple.teasers.math;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * 
 * Given numerator = 2, denominator = 1, return "2".
 * 
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author sarath
 *
 */
public class FractionToDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Numerator Input:");
		int x = in.nextInt();
		
		System.out.println("Denlominator :");
		int y = in.nextInt();
		
		System.out.println("FractionToDecimal? :" + FractionToDecimal.fractionToDecimal(x,y));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		String result = "";

		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		// quotient
		long res = num / den;
		result += String.valueOf(res);

		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		
		System.out.println("Remainder: " + remainder);
		
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			System.out.println("Result: " + res);
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
			System.out.println("Remainder: " + remainder);
		}

		return result;
	}

}
