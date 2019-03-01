package com.cdbt.service;

import com.cdbt.utils.CommonUtils;

public class OBSCalParmsService {
	public String[] getOBSResult(String num, String rwyEndAlt, String oBSAlt, String lineLength, String turnLength,
			String gradLoss, boolean selected) {
		double tree;
		if (selected) {
			tree = 15.0D;
		} else {
			tree = 0.0D;
		}
		double height = CommonUtils.strToDouble(oBSAlt).doubleValue() - CommonUtils.strToDouble(rwyEndAlt).doubleValue();
		double corrHeight = height + tree
				+ CommonUtils.strToDouble(turnLength).doubleValue() * CommonUtils.strToDouble(gradLoss).doubleValue() / 100.0D;
		double totalLength = CommonUtils.strToDouble(lineLength).doubleValue() + CommonUtils.strToDouble(turnLength).doubleValue();
		double obsGrad = corrHeight * 100.0D / totalLength;
		double obsGradWithoutTree = (corrHeight - tree) * 100.0D / totalLength;
		double obsGradResult = obsGrad + 0.8D;
		double obsGradWithoutTreeResult = obsGradWithoutTree + 0.8D;

		String[] result = { String.valueOf(num), oBSAlt, CommonUtils.doubleToStr(Double.valueOf(height), Integer.valueOf(1)),
				CommonUtils.doubleToStr(Double.valueOf(corrHeight), Integer.valueOf(1)),
				CommonUtils.doubleToStr(Double.valueOf(totalLength), Integer.valueOf(0)),
				CommonUtils.doubleToStr(Double.valueOf(obsGrad), Integer.valueOf(2)),
				CommonUtils.doubleToStr(Double.valueOf(obsGradWithoutTree), Integer.valueOf(2)),
				CommonUtils.doubleToStr(Double.valueOf(obsGradResult), Integer.valueOf(2)),
				CommonUtils.doubleToStr(Double.valueOf(obsGradWithoutTreeResult), Integer.valueOf(2)) };

		return result;
	}
}
