package com.cdbt.test;

public class MyTest {

	public static void main(String[] args) {
		KValAboutmeter(400, 20, 1000);
		KValAboutFt(400, -10, 8000);
	}

	public static void KValAboutmeter(double IAS, double VAR, double alt) {
		double K = 171233 * Math.pow(((288 + VAR) - 0.006496 * alt), 0.5) / Math.pow((288 - 0.006496 * alt), 2.628);
		double TAS = IAS * K;
		System.out.println("K=" + K + ",TAS=" + TAS);
	}

	public static void KValAboutFt(double IAS, double VAR, double alt) {
		double K = 171233 * Math.pow(((288 + VAR) - 0.00198 * alt), 0.5) / Math.pow((288 - 0.00198 * alt), 2.628);
		double TAS = IAS * K;
		System.out.println("K=" + K + ",TAS=" + TAS);
	}
}
