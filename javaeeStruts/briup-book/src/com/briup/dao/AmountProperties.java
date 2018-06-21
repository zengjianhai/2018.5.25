package com.briup.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AmountProperties {
	public static int getAmount(){
		Properties pro = new Properties();
		int amount = 0;
		try {
			pro.load(new FileInputStream("F:/eclipseWorkSpace/javaeeStruts/briup-book/src/amount.properties"));
			amount = Integer.parseInt(pro.getProperty("amount"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return amount;
	}
}
