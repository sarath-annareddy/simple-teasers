package org.dataapproach.simple.teasers.math;

import java.io.IOException;
import java.util.Scanner;

/**
 * Find if , an integer is a palindrome.
 * 
 * @author sarath
 *
 */
public class Palindrome {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		System.out.println("Input :" + x);
		System.out.println("Palindrome? :" + Palindrome.isPalindrome(x));
	}


    public static boolean isPalindrome(int x) {
        //negative numbers are not palindrome
		if (x < 0)
			return false;
 
		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
 
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
 
			if (left != right)
				return false;
 
			x = (x % div) / 10;
			System.out.println("after iteration: " + x);
			System.out.println("divisor :" + div);
			div /= 100;
		}
 
		return true;
    }
}