package org.dataapproach.simple.teasers.math;

import java.util.Scanner;

/**
 * A prime number is a whole number greater than 1, whose only two whole-number
 * factors are 1 and itself. The first few prime numbers are 2, 3, 5, 7, 11, 13,
 * 17, 19, 23, and 29.
 * 
 * Suppose n is a whole number, and we want to test it to see if it is prime.
 * First, we take the square root (or the 1/2 power) of n; then we round this
 * number up to the next highest whole number. Call the result m. We must find
 * all of the following quotients:
 * 
 * q(m) = n / m
 * 
 * q(m-1) = n / (m-1)
 * 
 * q(m-2) = n / (m-2)
 * 
 * q(m-3) = n / (m-3)
 * 
 * . . .
 * 
 * q3 = n / 3
 * 
 * q2 = n / 2
 * 
 * The number n is prime if and only if none of the q's, as derived above, are
 * whole numbers.
 * 
 * A Mersenne prime must be reducible to the form (2 Pow n) - 1, where n is a prime
 * number. The first few known values of n that produce Mersenne primes are
 * where n = 2, n = 3, n = 5, n = 7, n = 13, n = 17, n = 19, n = 31, n = 61, and
 * n = 89.
 * 
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * @author sarath
 *
 */
public class CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input number:");
		int x = in.nextInt();

		System.out.println("# of Primes :" + CountPrimes.countPrimes(x));

	}

	public static int countPrimes(int n) {
		if (n <= 2)
			return 0;

		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;

		// from 2 onwards, Loop thru till square-root of given number
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				// 2+2, 2+2+2, etc and 3+3, 3+3+3 etc etc are not prime numbers
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}
}
