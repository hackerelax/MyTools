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

	public String getObstacle(String SecendStart, String SecendEnd, String ENDHeight, String accHeight,
			String TargetDist, String TargetHeight, boolean isTurn) {
		double yudu;

		if (isTurn) {
			yudu = 15.239999976835199D;
		} else {
			yudu = 10.66799998378464D;
		}
		double Start = CommonUtils.strToDouble(SecendStart).doubleValue();
		double Secend = CommonUtils.strToDouble(SecendEnd).doubleValue();
		double END = CommonUtils.strToDouble(ENDHeight).doubleValue();
		double Height = CommonUtils.strToDouble(accHeight).doubleValue();
		double Target = CommonUtils.strToDouble(TargetDist).doubleValue();
		double GrossHeight = CommonUtils.strToDouble(TargetHeight).doubleValue();
		double h = 0.0D;
		double netHeight = 0.0D;
		double resHeight = 0.0D;
		double x = (37500 - Secend) * (Secend - Start) * 0.008
				/ (END - 300 - ((Height - Start * 0.008) - (Secend - Start) * 0.008));
		String location = "障碍物位于??";

		double h0 = Start * 0.8D / 100.0D;

		double netHeight0 = Height - h0;
		if (Target < Start) {
			h = Target * 0.8D / 100.0D;

			netHeight = GrossHeight - h;

			resHeight = netHeight - yudu;
			location = "障碍物位于爬升二段";
		}
		if ((Start <= Target) && (Target <= Secend + x)) {
			netHeight = Height - h0;

			resHeight = netHeight - yudu;
			location = "障碍物位于改平加速段";
		}
		if ((Target > Secend + x) && (Target < 37500)) {
			h = x * 0.8 / 100 + (Secend - Start) * 0.8 / 100 + h0 + (Target - x - Secend) * 0.8 / 100;
			netHeight = GrossHeight - h;

			resHeight = netHeight - yudu;
			location = "障碍物位于爬升四段";
		}
		if (Target >= 37500) {

			netHeight = GrossHeight - 300;

			resHeight = netHeight - yudu;
			location = "障碍物位于最后爬升段";
		}
		return

		"  结果：\n        35ft点到改平开始点水平距离为：" + CommonUtils.doubleToStr(Double.valueOf(Start), Integer.valueOf(0))
				+ "米\n        35ft点到改平结束点水平距离为： " + CommonUtils.doubleToStr(Double.valueOf(Secend), Integer.valueOf(0))
				+ "米\n        37.5km总高为：" + CommonUtils.doubleToStr(Double.valueOf(END), Integer.valueOf(0))
				+ "米\n        改平总高为：" + CommonUtils.doubleToStr(Double.valueOf(Height), Integer.valueOf(1))
				+ "米   ;  改平净高为：" + CommonUtils.doubleToStr(Double.valueOf(netHeight0), Integer.valueOf(1))
				+ "米\n        " + location + "\n        飞机飞至该处的飞行总高为："
				+ CommonUtils.doubleToStr(Double.valueOf(GrossHeight), Integer.valueOf(1)) + "米\n        飞机飞至该处的飞行净高为："
				+ CommonUtils.doubleToStr(Double.valueOf(netHeight), Integer.valueOf(1)) + "米\n        该处的障碍物限制高为："
				+ CommonUtils.doubleToStr(Double.valueOf(resHeight), Integer.valueOf(1)) + "米\n        净水平距离为："
				+ CommonUtils.doubleToStr(Double.valueOf(Secend + x), Integer.valueOf(1)) + "米";
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

	public String iasToTas(String IAS, String VAR, String ALT, String turnPD, boolean eng) {
		double ias = CommonUtils.strToDouble(IAS);
		double var = CommonUtils.strToDouble(VAR);
		double alt = CommonUtils.strToDouble(ALT);
		double turnpd = CommonUtils.strToDouble(turnPD);
		double K;
		double TAS;
		double R;
		double r;
		if (eng) {
			K = 171233 * Math.pow(((288 + var) - 0.00198 * alt), 0.5) / Math.pow((288 - 0.00198 * alt), 2.628);
			TAS = ias * K;
			R = 3431 * Math.tan(turnpd * Math.PI / 180) / (Math.PI * TAS);
			if (R > 3) {
				R = 3;
			}
			r = TAS / (20 * Math.PI * R) * 1.852;
			TAS = TAS * 1.852;
		} else {
			K = 171233 * Math.pow(((288 + var) - 0.006496 * alt), 0.5) / Math.pow((288 - 0.006496 * alt), 2.628);
			TAS = ias * K;
			R = 6355 * Math.tan(turnpd * Math.PI / 180) / (Math.PI * TAS);
			if (R > 3) {
				R = 3;
			}
			r = TAS / (20 * Math.PI * R);
		}
		double w = 12 * alt / 1000 + 87;
		double E30 = 30 / R * w / 3600;
		double E60 = 60 / R * w / 3600;
		double E90 = 90 / R * w / 3600;
		double E120 = 120 / R * w / 3600;
		double E150 = 150 / R * w / 3600;
		double E180 = 180 / R * w / 3600;
		double r0 = Math.pow(r * r + E90 * E90, 0.5);
		double r1 = r + E90;
		return "结果：\n       真空速为： " + CommonUtils.doubleToStr(TAS, 2) + " km/h = "
				+ CommonUtils.doubleToStr(TAS / 1.852, 2) + " kn\n       K值为：" + CommonUtils.doubleToStr(K, 4)
				+ "\n       转弯率R为：" + CommonUtils.doubleToStr(R, 3) + " °/s\n       转弯半径r为："
				+ CommonUtils.doubleToStr(r, 3) + " km\n      风速W为：" + CommonUtils.doubleToStr(w, 3)
				+ " km/h\n      (r^2+E^2)^1/2 = " + CommonUtils.doubleToStr(r0, 3) + " km\n      r+E= "
				+ CommonUtils.doubleToStr(r1, 3) + " km\n      E30为：" + CommonUtils.doubleToStr(E30, 3)
				+ " km\n      E60为：" + CommonUtils.doubleToStr(E60, 3) + " km\n      E90为："
				+ CommonUtils.doubleToStr(E90, 3) + " km\n      E120为：" + CommonUtils.doubleToStr(E120, 3)
				+ " km\n      E150为：" + CommonUtils.doubleToStr(E150, 3) + " km\n      E180为："
				+ CommonUtils.doubleToStr(E180, 3) + " km";
	}
}
