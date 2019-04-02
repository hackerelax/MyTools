package com.cdbt.service;

import java.util.ArrayList;

import com.cdbt.db.Database;
import com.cdbt.utils.CommonUtils;

public class FuelCalParmsService {
	private String AC_Info;
	private String FR_Info = "IFR-45";
	private String Pass_Info = "通航运营-75";
	private Database db = new Database();

	public ArrayList<String> getAC() {
		ArrayList<String> ac = this.db.getAC();
		return ac;
	}

	public ArrayList<String> getFR() {
		ArrayList<String> fr = this.db.getFR();
		return fr;
	}

	public ArrayList<String> getPass() {
		ArrayList<String> passenger = this.db.getPassenger();
		return passenger;
	}

	public String getDistResult(String tow, String pCount, String cargo, String climbFuel, String descFuel,
			String climbDist, String descDist, String climbTime, String descTime, String cruiseTAS,
			String cruiseFuelFlow, String altClimbFuel, String altDescFuel, String altClimbDist, String altDescDist,
			String altClimbTime, String altDescTime, String altTAS, String altFuelFlow, String altDist,
			String waiFuelflow, boolean b, boolean engUnit, String crewWt) {
		String[] ac = this.AC_Info.split("-");
		String[] fr = this.FR_Info.split("-");
		String[] pass = this.Pass_Info.split("-");
		String crewNum = ac[9];
		if (b) {
			crewNum = ac[10];
		}
		if (CommonUtils.strToDouble(tow).doubleValue() > CommonUtils.strToDouble(ac[2]).doubleValue()) {
			return "  该机型的起飞重量超出其结构限重！,   该机型的起飞重量超出其结构限重！";
		}
		if (CommonUtils.strToDouble(tow).doubleValue() <= CommonUtils.strToDouble(ac[1]).doubleValue()) {
			return "  该机型的起飞重量小于其空机重！,  该机型的起飞重量小于其空机重！";
		}
		if (CommonUtils.strToDouble(pCount).doubleValue() > CommonUtils.strToDouble(ac[3]).doubleValue()) {
			return "  该机型的乘客数超出其座位数！,  该机型的乘客数超出其座位数！";
		}
		if (CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[7]).doubleValue()) {
			return "  该机型的货物载量超出其货仓最大载量！,  该机型的货物载量超出其货仓最大载量！";
		}
		if (CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue()
				+ CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[5]).doubleValue()) {
			double c = Math.floor(CommonUtils.strToDouble(ac[5]).doubleValue()
					- CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue());
			double p = Math
					.floor((CommonUtils.strToDouble(ac[5]).doubleValue() - CommonUtils.strToDouble(cargo).doubleValue())
							/ CommonUtils.strToDouble(pass[1]).doubleValue());
			return "  已超出最大载量，调整货物为：" + CommonUtils.doubleToStr(Double.valueOf(c), Integer.valueOf(0)) + "kg、或者减少人数为："
					+ CommonUtils.doubleToStr(Double.valueOf(p), Integer.valueOf(0)) + "人,  已超出最大载量，调整货物为："
					+ CommonUtils.doubleToStr(Double.valueOf(c), Integer.valueOf(0)) + "kg、或者减少人数为："
					+ CommonUtils.doubleToStr(Double.valueOf(p), Integer.valueOf(0)) + "人";
		}
		Double dClimbFuel = CommonUtils.strToDouble(climbFuel);
		Double dClimbDist = CommonUtils.strToDouble(climbDist);
		Double dClimbTime = CommonUtils.strToDouble(climbTime);
		Double dDescFuel = CommonUtils.strToDouble(descFuel);
		Double dDescDist = CommonUtils.strToDouble(descDist);
		Double dDescTime = CommonUtils.strToDouble(descTime);
		Double dCruiseFuelFlow = CommonUtils.strToDouble(cruiseFuelFlow);
		Double dCruiseTAS = CommonUtils.strToDouble(cruiseTAS);
		Double dAltClimbFuel = CommonUtils.strToDouble(altClimbFuel);
		Double dAltClimbDist = CommonUtils.strToDouble(altClimbDist);
		Double dAltClimbTime = CommonUtils.strToDouble(altClimbTime);
		Double dAltDescFuel = CommonUtils.strToDouble(altDescFuel);
		Double dAltDescDist = CommonUtils.strToDouble(altDescDist);
		Double dAltDescTime = CommonUtils.strToDouble(altDescTime);
		Double dWaiFuelflow = CommonUtils.strToDouble(waiFuelflow);
		Double dAltFuelFlow = CommonUtils.strToDouble(altFuelFlow);
		Double dAltDist = CommonUtils.strToDouble(altDist);
		Double dAltTAS = CommonUtils.strToDouble(altTAS);
		Double dCrewWt = CommonUtils.strToDouble(crewWt);
		if (engUnit) {
			dClimbFuel = Double.valueOf(dClimbFuel.doubleValue() / 2.205D);
			dClimbDist = Double.valueOf(dClimbDist.doubleValue() * 1.852D);
			dDescFuel = Double.valueOf(dDescFuel.doubleValue() / 2.205D);
			dDescDist = Double.valueOf(dDescDist.doubleValue() * 1.852D);
			dCruiseFuelFlow = Double.valueOf(dCruiseFuelFlow.doubleValue() / 2.205D);
			dCruiseTAS = Double.valueOf(dCruiseTAS.doubleValue() * 1.852D);
			dAltClimbFuel = Double.valueOf(dAltClimbFuel.doubleValue() / 2.205D);
			dAltClimbDist = Double.valueOf(dAltClimbDist.doubleValue() * 1.852D);
			dAltDescFuel = Double.valueOf(dAltDescFuel.doubleValue() / 2.205D);
			dAltDescDist = Double.valueOf(dAltDescDist.doubleValue() * 1.852D);
			dAltFuelFlow = Double.valueOf(dAltFuelFlow.doubleValue() / 2.205D);
			dAltTAS = Double.valueOf(dAltTAS.doubleValue() * 1.852D);
			dWaiFuelflow = Double.valueOf(dWaiFuelflow.doubleValue() / 2.205D);
		}
		double totalFuel = CommonUtils.strToDouble(tow).doubleValue() - CommonUtils.strToDouble(ac[1]).doubleValue()
				- dCrewWt * CommonUtils.strToDouble(crewNum).doubleValue()
				- CommonUtils.strToDouble(cargo).doubleValue()
				- CommonUtils.strToDouble(pass[1]).doubleValue() * CommonUtils.strToDouble(pCount).doubleValue();
		double altFuel;
		double altTime;
		if (dAltDist == 0) {
			altFuel = dWaiFuelflow.doubleValue() * CommonUtils.minToHr(fr[1]).doubleValue();
			altTime = Double.valueOf(fr[1]);
		} else {
			altFuel = dWaiFuelflow.doubleValue() * CommonUtils.minToHr(fr[1]).doubleValue()
					+ dAltClimbFuel.doubleValue() + dAltDescFuel.doubleValue()
					+ (dAltDist.doubleValue() * 1.852D - dAltClimbDist.doubleValue() - dAltDescDist.doubleValue())
							/ dAltTAS.doubleValue() * dAltFuelFlow.doubleValue();

			altTime = dAltClimbTime.doubleValue() + dAltDescTime.doubleValue()
					+ (dAltDist.doubleValue() * 1.852D - dAltClimbDist.doubleValue() - dAltDescDist.doubleValue())
							/ dAltTAS.doubleValue() * 60.0D
					+ Double.valueOf(fr[1]);
			if (dAltDist * 1.8525D - dAltClimbDist - dAltDescDist < 0) {
				return "输入备降距离太短，请重新输入！,输入备降距离太短，请重新输入！";
			}
		}
		double cruiseFuel = totalFuel - altFuel - dClimbFuel.doubleValue() - dDescFuel.doubleValue();

		double cruiseTime = cruiseFuel / dCruiseFuelFlow.doubleValue() * 60.0D;

		double cruiseDist = dCruiseTAS.doubleValue() * cruiseTime / 60.0D;
		if (cruiseDist < 0) {
			return "没有巡航距离，请重新输入！,没有巡航距离，请重新输入！";
		}
		double totalTime = cruiseTime + dClimbTime.doubleValue() + dDescTime.doubleValue();

		double totalDist = cruiseDist + dClimbDist.doubleValue() + dDescDist.doubleValue();

		double totalFuelComsumtion = dClimbFuel.doubleValue() + dDescFuel.doubleValue() + cruiseFuel;

		double percent = CommonUtils.strToDouble(pCount).doubleValue() * 100.0D
				/ CommonUtils.strToDouble(ac[3]).doubleValue();
		if (totalFuel + CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue()
				+ CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[6]).doubleValue()) {
			return "  装载已超出该机型的最大载量，请检查！,  装载已超出该机型的最大载量，请检查！";
		}
		if (totalFuel > CommonUtils.strToDouble(ac[4]).doubleValue()) {
			return " 总油量已超出该机型的最大载油量，请检查！,  总油量已超出该机型的最大载油量，请检查！";
		}
		return

		"  距离相关结果：\n        主航程距离：" + CommonUtils.doubleToStr(Double.valueOf(totalDist), Integer.valueOf(2))
				+ "km\n        巡航距离：" + CommonUtils.doubleToStr(Double.valueOf(cruiseDist), Integer.valueOf(2))
				+ "km\n  时间相关结果：\n        主航程耗时："
				+ CommonUtils.doubleToStr(Double.valueOf(totalTime), Integer.valueOf(2)) + "min\n        巡航时间："
				+ CommonUtils.doubleToStr(Double.valueOf(cruiseTime), Integer.valueOf(2)) + "min\n        备降时间："
				+ CommonUtils.doubleToStr(Double.valueOf(altTime), Integer.valueOf(2))
				+ "min\n,  燃油相关结果：\n        总燃油量："
				+ CommonUtils.doubleToStr(Double.valueOf(totalFuel), Integer.valueOf(2)) + "kg\n        备份油量："
				+ CommonUtils.doubleToStr(Double.valueOf(altFuel), Integer.valueOf(2)) + "kg\n        主航程用油："
				+ CommonUtils.doubleToStr(Double.valueOf(totalFuelComsumtion), Integer.valueOf(2)) + "kg\n        巡航用油："
				+ CommonUtils.doubleToStr(Double.valueOf(cruiseFuel), Integer.valueOf(2)) + "kg\n  其他结果：\n        客座率："
				+ CommonUtils.doubleToStr(Double.valueOf(percent), Integer.valueOf(1)) + "%";
	}

	public String getDistInputInfo(String tow, String pCount, String cargo, String climbFuel, String descFuel,
			String climbDist, String descDist, String climbTime, String descTime, String cruiseTAS,
			String cruiseFuelFlow, String altClimbFuel, String altDescFuel, String altClimbDist, String altDescDist,
			String altClimbTime, String altDescTime, String altTAS, String altFuelflow, String altDist,
			String waiFuelflow, String yunying, String flightRule, boolean b, String crewWt) {
		if (flightRule != null) {
			this.FR_Info = flightRule;
		}
		if (yunying != null) {
			this.Pass_Info = yunying;
		}
		String[] ac = this.AC_Info.split("-");
		String[] fr = this.FR_Info.split("-");
		String[] yy = this.Pass_Info.split("-");
		String crewNum = ac[9];
		if (b) {
			crewNum = ac[10];
		}
		return

		"  飞行规则：" + fr[0] + "  \n  备降等待时间：" + fr[1] + " 分钟  \n  备降距离：" + altDist + " 海里\n  乘客人数：" + pCount
				+ "位\n  乘客重量：" + yy[1] + " 千克/位\n  货物重量：" + cargo + " 千克\n  起飞重量：" + tow + " 千克\n  机组人数：" + crewNum
				+ " 人\n  机组重量：" + crewWt + "千克/位";
	}

	public void getACInfo(String result) {
		this.AC_Info = result;
	}

	public void getFRInfo(String result) {
		this.FR_Info = result;
	}

	public void getPassInfo(String result) {
		this.Pass_Info = result;
	}

	public boolean addAC(String ac, String bow, String mtow, String seat, String maxFuel, String maxPayload,
			String maxTotalload, String cargo, String alt) throws Exception {
		ArrayList<String> arr = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		if ((CommonUtils.ifStringIsDigital(bow)) && (CommonUtils.ifStringIsDigital(mtow))
				&& (CommonUtils.ifStringIsDigital(seat)) && (CommonUtils.ifStringIsDigital(maxFuel))
				&& (CommonUtils.ifStringIsDigital(maxPayload)) && (CommonUtils.ifStringIsDigital(maxTotalload))
				&& (CommonUtils.ifStringIsDigital(cargo)) && (CommonUtils.ifStringIsDigital(alt))) {
			arr.add(ac);
			arr.add(bow);
			arr.add(mtow);
			arr.add(seat);
			arr.add(maxFuel);
			arr.add(maxPayload);
			arr.add(maxTotalload);
			arr.add(cargo);
			arr.add(alt);
			for (int i = 0; i < arr.size(); i++) {
				buffer.append((String) arr.get(i));
				buffer.append("-");
			}
			buffer.deleteCharAt(buffer.length() - 1);
			String result = new String(buffer.toString().getBytes(), "UTF-8");
			System.out.println(result);
			boolean b = this.db.addAC(result);
			return b;
		}
		return false;
	}

	public boolean deleteAC(String name) {
		System.out.println(name);
		return false;
	}

	public boolean editeAC(String name, String text, String text2, String text3, String text4, String text5,
			String text6, String text7, String text8) {
		System.out.println(name + text);
		return false;
	}

	public String getWeightInputInfo(String dist, String pCount, String cargo, String climbFuel, String descFuel,
			String climbDist, String descDist, String climbTime, String descTime, String cruiseTAS,
			String cruiseFuelFlow, String altClimbFuel, String altDescFuel, String altClimbDist, String altDescDist,
			String altClimbTime, String altDescTime, String altTAS, String altFuelflow, String altDist,
			String waiFuelflow, String yunying, String flightRule, boolean b, String crewWt) {
		if (flightRule != null) {
			this.FR_Info = flightRule;
		}
		if (yunying != null) {
			this.Pass_Info = yunying;
		}
		String[] ac = this.AC_Info.split("-");
		String[] fr = this.FR_Info.split("-");
		String[] yy = this.Pass_Info.split("-");
		String crewNum = ac[9];
		if (b) {
			crewNum = ac[10];
		}
		return

		"  飞行规则：" + fr[0] + "  \n  备降等待时间：" + fr[1] + " 分钟  \n  备降距离：" + altDist + " 海里\n  航路距离：" + dist
				+ " 千米\n  乘客人数：" + pCount + "位\n  乘客重量：" + yy[1] + " 千克/位\n  货物重量：" + cargo + " 千克\n  机组人数：" + crewNum
				+ " 人\n  机组重量：" + crewWt + "千克/位";
	}

	public String getWeightResult(String dist, String pCount, String cargo, String climbFuel, String descFuel,
			String climbDist, String descDist, String climbTime, String descTime, String cruiseTAS,
			String cruiseFuelFlow, String altClimbFuel, String altDescFuel, String altClimbDist, String altDescDist,
			String altClimbTime, String altDescTime, String altTAS, String altFuelFlow, String altDist,
			String waiFuelflow, boolean b, boolean engUnit, String crewWt) {
		String[] ac = this.AC_Info.split("-");
		String[] fr = this.FR_Info.split("-");
		String[] pass = this.Pass_Info.split("-");
		String crewNum = ac[9];
		if (b) {
			crewNum = ac[10];
		}
		if (CommonUtils.strToDouble(pCount).doubleValue() > CommonUtils.strToDouble(ac[3]).doubleValue()) {
			return "  该机型的乘客数超出其座位数！,  该机型的乘客数超出其座位数！";
		}
		if (CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[7]).doubleValue()) {
			return "  该机型的货物载量超出其货仓最大载量！,  该机型的货物载量超出其货仓最大载量！";
		}
		if (CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue()
				+ CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[5]).doubleValue()) {
			double c = Math.floor(CommonUtils.strToDouble(ac[5]).doubleValue()
					- CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue());
			double p = Math
					.floor((CommonUtils.strToDouble(ac[5]).doubleValue() - CommonUtils.strToDouble(cargo).doubleValue())
							/ CommonUtils.strToDouble(pass[1]).doubleValue());
			return "  已超出最大载量，调整货物为：" + CommonUtils.doubleToStr(Double.valueOf(c), Integer.valueOf(0)) + "kg、或者减少人数为："
					+ CommonUtils.doubleToStr(Double.valueOf(p), Integer.valueOf(0)) + "人,  已超出最大载量，调整货物为："
					+ CommonUtils.doubleToStr(Double.valueOf(c), Integer.valueOf(0)) + "kg、或者减少人数为："
					+ CommonUtils.doubleToStr(Double.valueOf(p), Integer.valueOf(0)) + "人";
		}
		Double dClimbFuel = CommonUtils.strToDouble(climbFuel);
		Double dClimbDist = CommonUtils.strToDouble(climbDist);
		Double dClimbTime = CommonUtils.strToDouble(climbTime);
		Double dDescFuel = CommonUtils.strToDouble(descFuel);
		Double dDescDist = CommonUtils.strToDouble(descDist);
		Double dDescTime = CommonUtils.strToDouble(descTime);
		Double dCruiseFuelFlow = CommonUtils.strToDouble(cruiseFuelFlow);
		Double dCruiseTAS = CommonUtils.strToDouble(cruiseTAS);
		Double dAltClimbFuel = CommonUtils.strToDouble(altClimbFuel);
		Double dAltClimbDist = CommonUtils.strToDouble(altClimbDist);
		Double dAltClimbTime = CommonUtils.strToDouble(altClimbTime);
		Double dAltDescFuel = CommonUtils.strToDouble(altDescFuel);
		Double dAltDescDist = CommonUtils.strToDouble(altDescDist);
		Double dAltDescTime = CommonUtils.strToDouble(altDescTime);
		Double dWaiFuelflow = CommonUtils.strToDouble(waiFuelflow);
		Double dAltFuelFlow = CommonUtils.strToDouble(altFuelFlow);
		Double dAltTAS = CommonUtils.strToDouble(altTAS);
		Double dAltDist = CommonUtils.strToDouble(altDist);
		Double dCrewWt = CommonUtils.strToDouble(crewWt);
		if (engUnit) {
			dClimbFuel = Double.valueOf(dClimbFuel.doubleValue() / 2.205D);
			dClimbDist = Double.valueOf(dClimbDist.doubleValue() * 1.852D);
			dDescFuel = Double.valueOf(dDescFuel.doubleValue() / 2.205D);
			dDescDist = Double.valueOf(dDescDist.doubleValue() * 1.852D);
			dCruiseFuelFlow = Double.valueOf(dCruiseFuelFlow.doubleValue() / 2.205D);
			dCruiseTAS = Double.valueOf(dCruiseTAS.doubleValue() * 1.852D);
			dAltFuelFlow = Double.valueOf(dAltFuelFlow.doubleValue() / 2.205D);
			dAltClimbFuel = Double.valueOf(dAltClimbFuel.doubleValue() / 2.205D);
			dAltClimbDist = Double.valueOf(dAltClimbDist.doubleValue() * 1.852D);
			dAltDescFuel = Double.valueOf(dAltDescFuel.doubleValue() / 2.205D);
			dAltDescDist = Double.valueOf(dAltDescDist.doubleValue() * 1.852D);
			dAltTAS = Double.valueOf(dAltTAS.doubleValue() * 1.852D);
			dWaiFuelflow = Double.valueOf(dWaiFuelflow.doubleValue() / 2.205D);
		}
		double cruiseDist = CommonUtils.strToDouble(dist).doubleValue() - dClimbDist.doubleValue()
				- dDescDist.doubleValue();
		if (cruiseDist < 0) {
			return "没有巡航距离，请重新输入！,没有巡航距离，请重新输入！";
		}
		double cruiseFuel = cruiseDist / dCruiseTAS.doubleValue() * dCruiseFuelFlow.doubleValue();

		double cruiseTime = cruiseFuel / dCruiseFuelFlow.doubleValue() * 60.0D;

		double totalFuelComsumtion = dClimbFuel.doubleValue() + dDescFuel.doubleValue() + cruiseFuel;

		double totalTime = cruiseTime + dClimbTime.doubleValue() + dDescTime.doubleValue();

		double altFuel;
		double altTime;
		if (dAltDist == 0) {
			altFuel = dWaiFuelflow.doubleValue() * CommonUtils.minToHr(fr[1]).doubleValue();
			altTime = Double.valueOf(fr[1]);
		} else {
			altFuel = dWaiFuelflow.doubleValue() * CommonUtils.minToHr(fr[1]).doubleValue()
					+ dAltClimbFuel.doubleValue() + dAltDescFuel.doubleValue()
					+ (dAltDist.doubleValue() * 1.852D - dAltClimbDist.doubleValue() - dAltDescDist.doubleValue())
							/ dAltTAS.doubleValue() * dAltFuelFlow.doubleValue();

			altTime = dAltClimbTime.doubleValue() + dAltDescTime.doubleValue()
					+ (dAltDist.doubleValue() * 1.852D - dAltClimbDist.doubleValue() - dAltDescDist.doubleValue())
							/ dAltTAS.doubleValue() * 60.0D
					+ Double.valueOf(fr[1]);
			if (dAltDist * 1.8525D - dAltClimbDist - dAltDescDist < 0) {
				return "输入备降距离太短，请重新输入！,输入备降距离太短，请重新输入！";
			}
		}
		double totalFuel = totalFuelComsumtion + altFuel;

		double tow = totalFuel + CommonUtils.strToDouble(ac[1]).doubleValue()
				+ dCrewWt * CommonUtils.strToDouble(crewNum).doubleValue()
				+ CommonUtils.strToDouble(cargo).doubleValue()
				+ CommonUtils.strToDouble(pass[1]).doubleValue() * CommonUtils.strToDouble(pCount).doubleValue();

		double percent = CommonUtils.strToDouble(pCount).doubleValue() * 100.0D
				/ CommonUtils.strToDouble(ac[3]).doubleValue();
		if (tow > CommonUtils.strToDouble(ac[2]).doubleValue()) {
			return "  该机型的起飞重量超出其结构限重！,   该机型的起飞重量超出其结构限重！";
		}
		if (tow <= CommonUtils.strToDouble(ac[1]).doubleValue()) {
			return "  该机型的起飞重量小于其空机重！,  该机型的起飞重量小于其空机重！";
		}
		if (totalFuel + CommonUtils.strToDouble(pCount).doubleValue() * CommonUtils.strToDouble(pass[1]).doubleValue()
				+ CommonUtils.strToDouble(cargo).doubleValue() > CommonUtils.strToDouble(ac[6]).doubleValue()) {
			return "  装载已超出该机型的最大载量，请检查！,  装载已超出该机型的最大载量，请检查！";
		}
		if (totalFuel > CommonUtils.strToDouble(ac[4]).doubleValue()) {
			return "  总油量已超出该机型的最大载油量，请检查！,  总油量已超出该机型的最大载油量，请检查！";
		}
		return

		"  重量相关结果：\n        起飞重量：" + CommonUtils.doubleToStr(Double.valueOf(tow), Integer.valueOf(2)) + "kg\n"
				+ "  距离和时间相关结果：\n        巡航距离："
				+ CommonUtils.doubleToStr(Double.valueOf(cruiseDist), Integer.valueOf(2)) + "km\n        主航程耗时："
				+ CommonUtils.doubleToStr(Double.valueOf(totalTime), Integer.valueOf(2)) + "min\n        巡航时间："
				+ CommonUtils.doubleToStr(Double.valueOf(cruiseTime), Integer.valueOf(2)) + "min\n        备降时间："
				+ CommonUtils.doubleToStr(Double.valueOf(altTime), Integer.valueOf(2))
				+ "min\n,  燃油相关结果：\n        总燃油量："
				+ CommonUtils.doubleToStr(Double.valueOf(totalFuel), Integer.valueOf(2)) + "kg\n        备份油量："
				+ CommonUtils.doubleToStr(Double.valueOf(altFuel), Integer.valueOf(2)) + "kg\n        主航程用油："
				+ CommonUtils.doubleToStr(Double.valueOf(totalFuelComsumtion), Integer.valueOf(2)) + "kg\n        巡航用油："
				+ CommonUtils.doubleToStr(Double.valueOf(cruiseFuel), Integer.valueOf(2)) + "kg\n  其他结果：\n        客座率："
				+ CommonUtils.doubleToStr(Double.valueOf(percent), Integer.valueOf(1)) + "%";
	}
}
