package com.cdbt.service;

import com.cdbt.utils.CommonUtils;

public class FunService {
	public String getFatResult(String height, String weight) {
		double parm = CommonUtils.strToDouble(weight).doubleValue()
				/ Math.pow(CommonUtils.strToDouble(height).doubleValue() / 100.0D, 2.0D);
		System.out.println(parm);
		if (parm > 25.0D) {
			return "胖纸该减肥老！";
		}
		return "不胖，继续吃！";
	}
}
