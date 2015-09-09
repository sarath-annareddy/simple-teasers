package org.dataapproach.simple.teasers.math;

import java.util.Scanner;

/**
 * @author sarath
 *
 */
public class XPowerN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input Number :");
		int x = in.nextInt();
		System.out.println("Input Power :");
		int n = in.nextInt();
		System.out.println("Powered :" + XPowerN.pow(x, n));

	}
	
	private static double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public static double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

}
