package com.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTest {

	public static void main(String[] args) {
		FileTest fTest = new FileTest();
		fTest.init("D:/file.txt", 3);
	}

	@SuppressWarnings("resource")
	public void init(String fileName, int id) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String val = null;//每行的内容
			String[] file_val = null;//每行分解成的数组
			int count = 0;//计行数
			int[] start = new int[6];//前3放对应的坐标，后3放位移
			Boolean flag = false;//判断是否出故障
			while ((val = br.readLine()) != null) {
				file_val = val.split(" ");
				if (count == 0) {
					if (count == id) {
						System.out.println(
								file_val[0] + " " + id + " " + file_val[1] + " " + file_val[2] + " " + file_val[3]);
						return;
					}
				} else {
					if (file_val.length < 7) {
						flag = true;
						if (count == id) {
							System.out.println("Error: " + id);
							return;
						}
					}
					if (count == id && flag) {
						System.out.println("Error: " + id);
					}
					if (((start[0] + start[3]) == Integer.valueOf(file_val[1]))
							&& ((start[1] + start[4]) == Integer.valueOf(file_val[2]))
							&& ((start[2] + start[5]) == Integer.valueOf(file_val[3])) && count == id) {
						System.out.println(
								file_val[0] + " " + id + " " + file_val[1] + " " + file_val[2] + " " + file_val[3]);
						return;
					}
					if (file_val.length >= 7) {
						start[3] = Integer.valueOf(file_val[4]);
						start[4] = Integer.valueOf(file_val[5]);
						start[5] = Integer.valueOf(file_val[6]);
					}
				}
				start[0] = Integer.valueOf(file_val[1]);
				start[1] = Integer.valueOf(file_val[2]);
				start[2] = Integer.valueOf(file_val[3]);
				count++;
			}
			if (id >= count) {
				System.out.println("Cannot find " + id);
			}
			if (br != null) {
				br.close();
			}
		} catch (Exception e) {
		}
	}
}
