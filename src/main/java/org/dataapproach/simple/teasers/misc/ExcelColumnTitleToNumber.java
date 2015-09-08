package org.dataapproach.simple.teasers.misc;

import java.util.Scanner;

/**
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number. For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... AAA -> 703
 * 
 * 
 * This problem is related to Excel Sheet Column Title. Starting from the
 * right-hand side, the converted value for each character is the mapping
 * integer * 26 to the t-th power, where t starts from 0.
 * 
 * @author sarath
 *
 */
public class ExcelColumnTitleToNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input column title:");
		String x = in.next();

		System.out.println("Corresponding # :"
				+ ExcelColumnTitleToNumber.titleToNumber(x));

	}

	public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		int result = 0;
		int i = s.length() - 1;
		int t = 0;
		// A to Z makes 26 letters, AA to AZ .. 26 cells, BA to BZ ... 26 cells and so on.
		while (i >= 0) {
			char curr = s.charAt(i);
			result = result + (int) Math.pow(26, t) * (curr - 'A' + 1);
			t++;
			i--;
		}

		return result;
	}

}
