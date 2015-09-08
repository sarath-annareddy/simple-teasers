package org.dataapproach.simple.teasers.math;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problems related with numbers are frequently solved by / and %. No need of
 * extra space is required.
 * 
 * @author sarath
 *
 */
public class ReverseInteger {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		System.out.println("Before Reverse :" + x);
		System.out.println("Reversed :" + ReverseInteger.reverse(x));
	}

	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		return rev;
	}

}
