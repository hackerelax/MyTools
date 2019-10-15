package com.cdbt.test;

public class MyTest {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 1;
		double result1 = ((-b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
		double result2 = ((-b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
		System.out.println(result1 + " & " + result2);
	}
}
