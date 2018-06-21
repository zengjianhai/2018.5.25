package com.springmvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
//第二种解决日期方案
public class StringToDateConverter implements Converter<String, Date>{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date convert(String str) {
		Date date = null;
		try {
			if(str!=null&&!"".equals(str.trim())){
				date = sdf.parse(str);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
