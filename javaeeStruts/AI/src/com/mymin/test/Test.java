package com.mymin.test;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import com.briup.db.SQLCreateFactory;

public class Test {
	public static void main(String[] args) {
		String sql = SQLCreateFactory.getCreate("com.mymin.sort.Student");
		System.out.println(sql);
		Locale locale = new Locale("en","US");
		NumberFormat mFormat= NumberFormat.getCurrencyInstance(locale);
		double val = 123.122;
		System.out.println(mFormat.format(val));
		ResourceBundle bundle = ResourceBundle.getBundle("com/mymin/test/message",Locale.CHINA);
		Object[] params = {"",new GregorianCalendar().getTime()};
		String string = new MessageFormat(bundle.getString("repass"), Locale.CHINA).format(params);
		System.out.println(string);
	}
}
