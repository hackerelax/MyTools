package com.cdbt.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cdbt.utils.CommonUtils;

public class TaxService {
	public String getTax(String total, String deduction) {
		if ((ifStringIsDigital(total)) && (ifStringIsDigital(deduction))) {
			double income = CommonUtils.strToDouble(total).doubleValue() - CommonUtils.strToDouble(deduction).doubleValue();
			double tax = 0.0D;
			if ((income <= 5000.0D) && (income > 0.0D)) {
				tax = 0.0D;
			}
			if ((income <= 8000.0D) && (income > 5000.0D)) {
				tax = (income - 5000.0D) * 3.0D / 100.0D;
			}
			if ((income <= 17000.0D) && (income > 8000.0D)) {
				tax = 90.0D + (income - 8000.0D) * 10.0D / 100.0D;
			}
			if ((income <= 30000.0D) && (income > 17000.0D)) {
				tax = 990.0D + (income - 17000.0D) * 20.0D / 100.0D;
			}
			if ((income <= 40000.0D) && (income > 30000.0D)) {
				tax = 3590.0D + (income - 30000.0D) * 25.0D / 100.0D;
			}
			if ((income <= 60000.0D) && (income > 40000.0D)) {
				tax = 6090.0D + (income - 40000.0D) * 30.0D / 100.0D;
			}
			if ((income <= 85000.0D) && (income > 60000.0D)) {
				tax = 12090.0D + (income - 60000.0D) * 35.0D / 100.0D;
			}
			if (income > 85000.0D) {
				tax = 20840.0D + (income - 85000.0D) * 45.0D / 100.0D;
			}
			return CommonUtils.doubleToStr(Double.valueOf(tax), Integer.valueOf(2));
		}
		return null;
	}

	public boolean ifStringIsDigital(String str) {
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
		Matcher matcher = pattern.matcher(str);
		boolean result = matcher.matches();
		return result;
	}
}
