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
	String DirLocation = "C:/Users/Administrator/Documents/java";
	String ACInfoLocation = "C:/Users/Administrator/Documents/java/AC_Data.txt";
	String FRInfoLocation = "C:/Users/Administrator/Documents/java/FR_Data.txt";
	String PassgerInfoLocation = "C:/Users/Administrator/Documents/java/ADC_Data.txt";

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
				// 名称-空重-最大起飞重量-乘客数-最大可用燃油-最大商载-总最大载量-行李舱最大载量-升限-最少机组-最大机组
				String k350i = "K350i-4454-6804-9-1638-1154-2334-250-10668-1-2";
				String pc12 = "PC12-2796-4740-9-1226-1024-1849-700-9144-1-2";
				String y12e = "Y12E-3392-5670-18-1230-1984-2138-360-7000-2-2";
				String y12f = "Y12F-4596-8400-19-2454-3000-3622-300-7000-2-2";
				String c90GTx = "C90GTx-3150-4581-5-1133-1046-1431-159-9144-1-2";
				String phenom300 = "Phenom300-5150-8150-9-2428-1200-3000-260-13716-1-2";
				String e190 = "E190-28000-50300-108-13192-12800-12800-2540-12497-2-2";
				String c208B = "C208B-2393-3995-9-1009-1463-1618-640-7620-1-2";
				String c172S = "C172S-755-1156-3-144-406-406-54.4-4100-1-1";
				String kodiak100 = "KODIAK100-1712-3290-9-987-1601-1601-90-7620-1-2";
				String da42L = "DA42L-1255-1785-3-208-530-530-75-5486-1-1";
				FileOutputStream os = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				bw.write(k350i);
				bw.newLine();
				bw.write(pc12);
				bw.newLine();
				bw.write(y12e);
				bw.newLine();
				bw.write(y12f);
				bw.newLine();
				bw.write(c90GTx);
				bw.newLine();
				bw.write(c208B);
				bw.newLine();
				bw.write(c172S);
				bw.newLine();
				bw.write(kodiak100);
				bw.newLine();
				bw.write(da42L);
				bw.newLine();
				bw.write(phenom300);
				bw.newLine();
				bw.write(e190);
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
