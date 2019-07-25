package com.cdbt.service;

import com.cdbt.utils.CommonUtils;

public class NormalCalParmsService {
	public String chazhifa(String a1, String a2, String b1, String b2, String t1) {
		Double A1 = Double.valueOf(a1);
		Double A2 = Double.valueOf(a2);
		Double B1 = Double.valueOf(b1);
		Double B2 = Double.valueOf(b2);
		Double T1 = Double.valueOf(t1);
		double T2 = (B1.doubleValue()
				+ (A1.doubleValue() - T1.doubleValue()) / (T1.doubleValue() - A2.doubleValue()) * B2.doubleValue())
				/ ((A1.doubleValue() - T1.doubleValue()) / (T1.doubleValue() - A2.doubleValue()) + 1.0D);
		return CommonUtils.doubleToStr(Double.valueOf(T2), Integer.valueOf(2));
	}

	public String ftToMeter(String ft) {
		Double FT = Double.valueOf(ft);
		double meter = FT.doubleValue() / 3.2808399D;
		return CommonUtils.doubleToStr(Double.valueOf(meter), Integer.valueOf(3));
	}

	public String meterToFeet(String meter) {
		Double METER = Double.valueOf(meter);
		double feet = METER.doubleValue() * 3.2808399D;
		return CommonUtils.doubleToStr(Double.valueOf(feet), Integer.valueOf(3));
	}

	public String kmToNm(String km) {
		Double KM = Double.valueOf(km);
		double nm = KM.doubleValue() / 1.852D;
		return CommonUtils.doubleToStr(Double.valueOf(nm), Integer.valueOf(3));
	}

	public String nmToKm(String nm) {
		Double NM = Double.valueOf(nm);
		double km = NM.doubleValue() * 1.852D;
		return CommonUtils.doubleToStr(Double.valueOf(km), Integer.valueOf(3));
	}

	public String kgToLb(String kg) {
		Double KG = Double.valueOf(kg);
		double lb = KG.doubleValue() * 2.2046226D;
		return CommonUtils.doubleToStr(Double.valueOf(lb), Integer.valueOf(3));
	}

	public String lbToKg(String lb) {
		Double LB = Double.valueOf(lb);
		double kg = LB.doubleValue() / 2.2046226D;
		return CommonUtils.doubleToStr(Double.valueOf(kg), Integer.valueOf(3));
	}

	public String fpmToGrad(String fpm, String tas) {
		Double FPM = Double.valueOf(fpm);
		Double TAS = Double.valueOf(tas);
		double grad = FPM.doubleValue() * 100.0D
				/ Math.sqrt(Math.pow(TAS.doubleValue() * 101.2D, 2.0D) - Math.pow(FPM.doubleValue(), 2.0D));
		return CommonUtils.doubleToStr(Double.valueOf(grad), Integer.valueOf(3));
	}

	public String gradToFpm(String grad, String tas) {
		Double GRAD = Double.valueOf(grad);
		Double TAS = Double.valueOf(tas);
		double FPM = Math.sqrt(Math.pow(GRAD.doubleValue() / 100.0D * TAS.doubleValue() * 101.2D, 2.0D)
				/ (1.0D + Math.pow(GRAD.doubleValue() / 100.0D, 2.0D)));
		return CommonUtils.doubleToStr(Double.valueOf(FPM), Integer.valueOf(3));
	}

	public String cToISA(String c, String alt, boolean checked) {
		Double C = Double.valueOf(c);
		Double ALT = Double.valueOf(alt);
		double djl = 6.5D;
		if (checked) {
			djl = 2.0D;
		}
		double isa = C.doubleValue() - (15.0D - djl * ALT.doubleValue() / 1000.0D);
		String result = CommonUtils.doubleToStr(Double.valueOf(isa), Integer.valueOf(1));
		if (isa > 0.0D) {
			return "+" + result;
		}
		return result;
	}

	public String isaToC(String isa, String alt, boolean checked) {
		Double ISA = Double.valueOf(isa);
		Double ALT = Double.valueOf(alt);
		double djl = 6.5D;
		if (checked) {
			djl = 2.0D;
		}
		double c = 15.0D - ALT.doubleValue() / 1000.0D * djl + ISA.doubleValue();
		String result = CommonUtils.doubleToStr(Double.valueOf(c), Integer.valueOf(1));
		if (c > 0.0D) {
			return "+" + result;
		}
		return result;
	}

	public String mToKmh(String m, boolean checked, String alt, String isa) {
		Double M = Double.valueOf(m);
		Double ALT = Double.valueOf(alt);
		Double ISA = Double.valueOf(isa);
		double djl = 6.5D;
		if (checked) {
			djl = 2.0D;
		}
		double c = 15.0D - ALT.doubleValue() / 1000.0D * djl + ISA.doubleValue();
		double soundSeed = 331.45D * Math.sqrt(1.0D + c / 273.15D);
		String SS = CommonUtils.doubleToStr(Double.valueOf(soundSeed), Integer.valueOf(2)) + "m/s";
		double kmh = M.doubleValue() * 3.6D * soundSeed;
		String KMH = CommonUtils.doubleToStr(Double.valueOf(kmh), Integer.valueOf(2));
		return SS + "-" + KMH;
	}

	public String kmhToM(String kmh, boolean checked, String alt, String isa) {
		Double KMH = Double.valueOf(kmh);
		Double ALT = Double.valueOf(alt);
		Double ISA = Double.valueOf(isa);
		double djl = 6.5D;
		if (checked) {
			djl = 2.0D;
		}
		double c = 15.0D - ALT.doubleValue() / 1000.0D * djl + ISA.doubleValue();
		double soundSeed = 331.45D * Math.sqrt(1.0D + c / 273.15D);
		String SS = CommonUtils.doubleToStr(Double.valueOf(soundSeed), Integer.valueOf(1)) + "m/s";
		double m = KMH.doubleValue() / 3.6D / soundSeed;
		String M = CommonUtils.doubleToStr(Double.valueOf(m), Integer.valueOf(2));
		return SS + "-" + M;
	}

	public String getWet(String dry) {
		Double DRY = Double.valueOf(dry);
		double wet = DRY.doubleValue() * 1.15D;
		return CommonUtils.doubleToStr(Double.valueOf(wet), Integer.valueOf(2));
	}

	public String getDecimal(String du, String fen, String miao) {
		double result = CommonUtils.strToDouble(du).doubleValue()
				+ (CommonUtils.strToDouble(fen).doubleValue() + CommonUtils.strToDouble(miao).doubleValue() / 60.0D)
						/ 60.0D;
		return CommonUtils.doubleToStr(Double.valueOf(result), Integer.valueOf(6));
	}

	public String getDFM(String decimal) {
		Double DECIMAL = Double.valueOf(decimal);
		double du = Math.floor(DECIMAL.doubleValue());
		double fen = Math.floor((DECIMAL.doubleValue() - du) * 60.0D);
		double miao = ((DECIMAL.doubleValue() - du) * 60.0D - fen) * 60.0D;
		String DU = CommonUtils.doubleToStr(Double.valueOf(du), Integer.valueOf(0));
		String FEN = CommonUtils.doubleToStr(Double.valueOf(fen), Integer.valueOf(0));
		String Miao = CommonUtils.doubleToStr(Double.valueOf(miao), Integer.valueOf(2));
		if (Miao.equals("60.0")) {
			Miao = "0";
			fen += 1.0D;
		}
		if (fen == 60.0D) {
			fen = 0.0D;
			du += 1.0D;
		}
		return DU + "-" + FEN + "-" + Miao;
	}

	public String getTargetAlt(String startAlt, String targetDist, String gradient) {
		if (startAlt.isEmpty()) {
			startAlt = "0";
		}
		double STARTALT = CommonUtils.strToDouble(startAlt).doubleValue();
		double TARGETDIST = CommonUtils.strToDouble(targetDist).doubleValue();
		double GRADIENT = CommonUtils.strToDouble(gradient).doubleValue();
		double hight = TARGETDIST * GRADIENT / 100.0D;
		double targetAlt = STARTALT + hight;
		if (STARTALT == 0.0D) {
			return CommonUtils.doubleToStr(Double.valueOf(hight), Integer.valueOf(1));
		}
		return CommonUtils.doubleToStr(Double.valueOf(targetAlt), Integer.valueOf(1)) + "/"
				+ CommonUtils.doubleToStr(Double.valueOf(hight), Integer.valueOf(1));
	}

	public String getGrad(String startAlt, String targetDist, String targetAlt) {
		if (startAlt.isEmpty()) {
			startAlt = "0";
		}
		double STARTALT = CommonUtils.strToDouble(startAlt).doubleValue();
		double TARGETDIST = CommonUtils.strToDouble(targetDist).doubleValue();
		double TARGETALT = CommonUtils.strToDouble(targetAlt).doubleValue();
		double gradient = (TARGETALT - STARTALT) * 100.0D / TARGETDIST;
		return CommonUtils.doubleToStr(Double.valueOf(gradient), Integer.valueOf(2));
	}

	public String getDist(String startAlt, String gradient, String targetAlt) {
		if (startAlt.isEmpty()) {
			startAlt = "0";
		}
		double STARTALT = CommonUtils.strToDouble(startAlt).doubleValue();
		double GRADIENT = CommonUtils.strToDouble(gradient).doubleValue();
		double TARGETALT = CommonUtils.strToDouble(targetAlt).doubleValue();
		double dist = (TARGETALT - STARTALT) * 100.0D / GRADIENT;
		return CommonUtils.doubleToStr(Double.valueOf(dist), Integer.valueOf(0));
	}

	public String getObstacle(String RtoStart, String RtoSecend, String RtoThird, String accHeight, String RtoTarget,
			String grossHeight, boolean isTurn) {
		double yudu;

		if (isTurn) {
			yudu = 15.239999976835199D;
		} else {
			yudu = 10.66799998378464D;
		}
		double Start = CommonUtils.strToDouble(RtoStart).doubleValue();
		double Secend = CommonUtils.strToDouble(RtoSecend).doubleValue();
		double Third = CommonUtils.strToDouble(RtoThird).doubleValue();
		double Height = CommonUtils.strToDouble(accHeight).doubleValue();
		double Target = CommonUtils.strToDouble(RtoTarget).doubleValue();
		double GrossHeight = CommonUtils.strToDouble(grossHeight).doubleValue();
		double h = 0.0D;
		double netHeight = 0.0D;
		double resHeight = 0.0D;
		String location = "障碍物位于??";

		double h0 = (Secend - Start) * 0.8D / 100.0D;

		double netHeight0 = Height - h0;
		if (Target < Secend) {
			h = (Target - Start) * 0.8D / 100.0D;

			netHeight = GrossHeight - h;

			resHeight = netHeight - yudu;
			location = "障碍物位于爬升二段";
		}
		if ((Secend <= Target) && (Target <= Third)) {
			netHeight = GrossHeight - h0;

			resHeight = netHeight - yudu;
			location = "障碍物位于改平加速段";
		}
		if (Target > Third) {
			h = (Target - Third + Secend - Start) * 0.8D / 100.0D;

			netHeight = GrossHeight - h;

			resHeight = netHeight - yudu;
			location = "障碍物位于最后爬升段";
		}
		return

		"  结果：\n        35ft点到参考0点水平距离为：" + CommonUtils.doubleToStr(Double.valueOf(Start), Integer.valueOf(0))
				+ "米\n        改平开始点到参考0点距离为：" + CommonUtils.doubleToStr(Double.valueOf(Secend), Integer.valueOf(0))
				+ "米\n        改平结束点到参考0点距离为：" + CommonUtils.doubleToStr(Double.valueOf(Third), Integer.valueOf(0))
				+ "米\n        改平总高为：" + CommonUtils.doubleToStr(Double.valueOf(Height), Integer.valueOf(1))
				+ "米   ;  改平净高为：" + CommonUtils.doubleToStr(Double.valueOf(netHeight0), Integer.valueOf(1))
				+ "米\n        " + location + "\n        飞机飞至该处的飞行总高为："
				+ CommonUtils.doubleToStr(Double.valueOf(GrossHeight), Integer.valueOf(1)) + "米\n        飞机飞至该处的飞行净高为："
				+ CommonUtils.doubleToStr(Double.valueOf(netHeight), Integer.valueOf(1)) + "米\n        该处的障碍物限制高为："
				+ CommonUtils.doubleToStr(Double.valueOf(resHeight), Integer.valueOf(1)) + "米";
	}

	public String arcLengthToOther(String R, String ARCLength) {
		double r = CommonUtils.strToDouble(R).doubleValue();
		double arcLen = CommonUtils.strToDouble(ARCLength).doubleValue();
		double angle = 360.0D * arcLen / (2.0D * r * 3.141592653589793D);
		double chordLen = 2.0D * r * Math.sin(angleToRad(Double.valueOf(angle)).doubleValue() / 2.0D);
		return CommonUtils.doubleToStr(Double.valueOf(angle), Integer.valueOf(4)) + "-"
				+ CommonUtils.doubleToStr(Double.valueOf(chordLen), Integer.valueOf(4));
	}

	public String angleToOther(String R, String ANGLE) {
		double r = CommonUtils.strToDouble(R).doubleValue();
		double angle = CommonUtils.strToDouble(ANGLE).doubleValue();
		double arcLen = 2.0D * r * 3.141592653589793D * angle / 360.0D;
		double chordLen = 2.0D * r * Math.sin(angleToRad(Double.valueOf(angle)).doubleValue() / 2.0D);
		return CommonUtils.doubleToStr(Double.valueOf(arcLen), Integer.valueOf(4)) + "-"
				+ CommonUtils.doubleToStr(Double.valueOf(chordLen), Integer.valueOf(4));
	}

	public String chordLengthToOther(String R, String ChordLength) {
		double r = CommonUtils.strToDouble(R).doubleValue();
		double chordLen = CommonUtils.strToDouble(ChordLength).doubleValue();
		double angle = radToAngle(Double.valueOf(Math.asin(chordLen / r / 2.0D) * 2.0D)).doubleValue();
		double arcLen = 2.0D * r * 3.141592653589793D * angle / 360.0D;
		return CommonUtils.doubleToStr(Double.valueOf(arcLen), Integer.valueOf(4)) + "-"
				+ CommonUtils.doubleToStr(Double.valueOf(angle), Integer.valueOf(4));
	}

	public String rToAng(String rad) {
		return CommonUtils.doubleToStr(
				Double.valueOf(CommonUtils.strToDouble(rad).doubleValue() * 180.0D / 3.141592653589793D),
				Integer.valueOf(4));
	}

	public String angToR(String ang) {
		return CommonUtils.doubleToStr(
				Double.valueOf(CommonUtils.strToDouble(ang).doubleValue() * 3.141592653589793D / 180.0D),
				Integer.valueOf(4));
	}

	public Double radToAngle(Double rad) {
		return Double.valueOf(rad.doubleValue() * 180.0D / 3.141592653589793D);
	}

	public Double angleToRad(Double angle) {
		return Double.valueOf(angle.doubleValue() * 3.141592653589793D / 180.0D);
	}

	public String lengthToWidth(String leng, String start, String bl) {
		double result = (CommonUtils.strToDouble(leng) * CommonUtils.strToDouble(bl) / 100
				+ CommonUtils.strToDouble(start)) * 2;

		return CommonUtils.doubleToStr(result, 3);
	}

	public String widthToLength(String width, String start, String bl) {
		double result = (CommonUtils.strToDouble(width) / 2 - CommonUtils.strToDouble(start))
				/ (CommonUtils.strToDouble(bl) / 100);

		return CommonUtils.doubleToStr(result, 3);
	}

	public String iasToTas(String IAS, String VAR, String ALT, boolean eng) {
		double ias = CommonUtils.strToDouble(IAS);
		double var = CommonUtils.strToDouble(VAR);
		double alt = CommonUtils.strToDouble(ALT);
		if (eng) {
			double K = 171233 * Math.pow(((288 + var) - 0.00198 * alt), 0.5) / Math.pow((288 - 0.00198 * alt), 2.628);
			double TAS = ias * K;
			return CommonUtils.doubleToStr(TAS, 2) + "-" + CommonUtils.doubleToStr(K, 4);
		} else {
			double K = 171233 * Math.pow(((288 + var) - 0.006496 * alt), 0.5) / Math.pow((288 - 0.006496 * alt), 2.628);
			double TAS = ias * K;
			return CommonUtils.doubleToStr(TAS, 2) + "-" + CommonUtils.doubleToStr(K, 4);
		}

	}
}
