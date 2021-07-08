package com.cdbt.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Database {
	String DirLocation = "C:/Users/public/Documents/java";
	String ACInfoLocation = "C:/Users/public/Documents/java/AC_Data.txt";
	String FRInfoLocation = "C:/Users/public/Documents/java/FR_Data.txt";
	String PassgerInfoLocation = "C:/Users/public/Documents/java/ADC_Data.txt";

	public ArrayList<String> getAC() {
		ArrayList<String> aircraft = new ArrayList<String>();
		File dir = new File(this.DirLocation);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(this.ACInfoLocation);
		if (!file.exists()) {
			writeAC_Info();
		}
		aircraft = readFile(file);
		return aircraft;
	}

	public ArrayList<String> getFR() {
		ArrayList<String> Fr = new ArrayList<String>();
		File dir = new File(this.DirLocation);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(this.FRInfoLocation);
		if (!file.exists()) {
			writeFR_Info();
		}
		Fr = readFile(file);
		return Fr;
	}

	public ArrayList<String> getPassenger() {
		ArrayList<String> Pass = new ArrayList<String>();
		File dir = new File(this.DirLocation);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(this.PassgerInfoLocation);
		if (!file.exists()) {
			writeADC_Info();
		}
		Pass = readFile(file);
		return Pass;
	}

	public void writeAC_Info() {
		try {
			File file = new File(this.ACInfoLocation);
			if (!file.exists()) {
				file.createNewFile();
				// 名称-空重-最大起飞重量-最大着陆重量-总人数-最大可用燃油-最大商载-行李舱最大载量-升限-最少机组-最大机组-飞行区等级
				String Kodiak100 = "KODIAK100-1713-3290-3034-11-972-1601-90-7620-1-2-1A";
				String C208B = "C208B-2270-3969-3855-11-1024-1938-250-7620-1-2-1B";
				String Pc12 = "PC12-2796-4740-4500-11-1226-1304-180-9144-1-2-2B";
				String C90GTx = "C90GTx-3150-4581-4354-8-1167-1241-159-9144-1-2-2B";
				String K350i = "K350i-4454-6804-6804-11-1638-1154-250-10668-1-2-2B";
				String Dhc = "DHC6-3108-5670-5580-20-1172-2472-356-7620-1-2-2B";
				String Y12e = "Y12E-3392-5670-5400-20-1230-1796-360-7000-2-2-2B";
				String Y12f = "Y12F-4596-8400-8000-21-2454-3000-300-7000-2-2-3B";
				String Ce525 = "CE525-2913-4808-4445-8-1460-897-280-12496-2-2-2A";
				String Phenom300 = "Phenom300-5150-8150-7650-10-2428-1196-260-13716-1-2-2B";
				String G550 = "G550-20909-41277-34155-22-18734-2812-500-15544-2-2-4C";
				FileOutputStream os = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				bw.write(Kodiak100);
				bw.newLine();
				bw.write(C208B);
				bw.newLine();
				bw.write(Pc12);
				bw.newLine();
				bw.write(C90GTx);
				bw.newLine();
				bw.write(K350i);
				bw.newLine();
				bw.write(Dhc);
				bw.newLine();
				bw.write(Y12e);
				bw.newLine();
				bw.write(Y12f);
				bw.newLine();
				bw.write(Ce525);
				bw.newLine();
				bw.write(Phenom300);
				bw.newLine();
				bw.write(G550);
				bw.newLine();
				bw.close();
				System.out.println("Done!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed!");
		}
	}

	public void writeFR_Info() {
		try {
			File file = new File(this.FRInfoLocation);
			if (!file.exists()) {
				file.createNewFile();
				String ifr = "IFR-45-200";
				String vfr = "VFR-30-0";
				FileOutputStream os = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				bw.write(ifr);
				bw.newLine();
				bw.write(vfr);
				bw.newLine();
				bw.close();
				System.out.println("Done!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed!");
		}
	}

	public void writeADC_Info() {
		try {
			File file = new File(this.PassgerInfoLocation);
			if (!file.exists()) {
				file.createNewFile();
				String th = "通航运营-75";
				String zx = "支线运营-95";
				FileOutputStream os = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				bw.write(th);
				bw.newLine();
				bw.write(zx);
				bw.newLine();
				bw.close();
				System.out.println("Done!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed!");
		}
	}

	public boolean writeFile(String fileName, String string) {
		try {
			@SuppressWarnings("resource")
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			if (randomFile.readBoolean()) {
				long fileLength = randomFile.length();
				randomFile.seek(fileLength);
				randomFile.writeBytes(string + "\r\n");
				randomFile.close();
				System.out.println("Done!");
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed!");
		}
		return false;
	}

	public ArrayList<String> readFile(File file) {
		String encoding = "UTF-8";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			if ((file.isFile()) && (file.exists())) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding);

				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(isr);
				String context = null;
				while ((context = reader.readLine()) != null) {
					arr.add(context);
				}
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addAC(String result) {
		String file = this.ACInfoLocation;
		writeFile(file, result);
		return true;
	}
}
