package com.briup.struts.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OGNLProperties {
	private static String value;
	private static Properties properties;

	static {
		if (properties == null) {
			properties = new Properties();
		}
		try {
			properties.load(new FileInputStream("F:/eclipseWorkSpace"
					+ "/javaeeStruts/briup-struts/src/OGNLValue.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue() {
		value = properties.getProperty("Tip");
		System.err.println("----执行成功----");
		return value;
	}
}
