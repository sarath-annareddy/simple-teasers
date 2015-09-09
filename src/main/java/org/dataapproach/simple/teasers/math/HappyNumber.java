package org.dataapproach.simple.teasers.math;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * What is an happy number can be shown in the following example:
 * 
 * 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 
 * 8^2 + 2^2 = 68
 * 
 * 6^2 + 8^2 = 100
 * 
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * Analysis
 * 
 * The key to solve this problem is the stop condition for the loop.
 * 
 * 
 * @author sarath
 *
 */
public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input Number:");
		int x = in.nextInt();
		
		
		System.out.println("Happy Number? :" + HappyNumber.happyNumber(x));

	}
	
	public static boolean happyNumber(int n) {
	    HashSet<Integer> set = new HashSet<Integer>();
	 
	    while(!set.contains(n)){
	        set.add(n);
	 
	        n = sum(getDigits(n));
	        if (n == 1)
	            return true;
	    }
	 
	    return false;
	}
	 
	private static int sum(int[] arr){
	    int sum = 0;
	    for(int i: arr){
	        sum = sum + i*i;
	    }
	    return sum;
	}
	 
	private static int[] getDigits(int n){
	    String s = String.valueOf(n);
	    int[] result = new int[s.length()];
	    int i=0;
	 
	    while(n>0){
	        int m = n%10;
	        result[i++] = m;
	        n = n/10;
	    }
	 
	    return result;
	}

}
