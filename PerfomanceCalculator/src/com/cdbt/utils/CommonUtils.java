package com.cdbt.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	public static boolean ifStringIsDigital(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[0-9]+(.[0-9]+)?$");
		Matcher matcher = pattern.matcher(str);
		boolean result = matcher.matches();
		return result;
	}

	public static boolean ifStringIsInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[0-9]*");
		Matcher matcher = pattern.matcher(str);
		boolean result = matcher.matches();
		return result;
	}

	public static boolean ifStringIsPositive(String str) {
		boolean b = ifStringIsDigital(str);
		if (b) {
			Double value = Double.valueOf(str);
			if (value.doubleValue() >= 0.0D) {
				return true;
			}
			return false;
		}
		return false;
	}

	public static Double strToDouble(String str) {
		return Double.valueOf(str);
	}

	public static String doubleToStr(Double db, Integer ws) {
		return String.format("%." + ws + "f", new Object[] { db });
	}

	public static Double minToHr(String min) {
		return Double.valueOf(Double.valueOf(min).doubleValue() / 60.0D);
	}
}
