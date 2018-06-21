package com.runner.common.util;

import com.runner.common.util.ip.IPSeeker;


public class Util {
	public static String PROVINCE[] = { "璇烽�夋嫨", "鍖椾含", "涓婃捣", "澶╂触", "閲嶅簡", "杈藉畞",
			"骞夸笢", "娴欐睙", "姹熻嫃", "灞变笢", "鍥涘窛", "榛戦緳姹�", "婀栧崡", "婀栧寳", "娌冲崡", "瀹夊窘", "娌冲寳",
			"鍚夋灄", "姹熻タ", "骞胯タ", "灞辫タ", "鍐呰挋鍙�", "鐢樿們", "璐靛窞", "鏂扮枂", "浜戝崡", "瀹佸", "娴峰崡",
			"闈掓捣", "瑗胯棌", "娓境鍙�", "娴峰", "鍏跺畠" };

	public static String getProvinceNameById(String id) {
		return PROVINCE[Integer.parseInt(id)];
	}

	public static String getAddress(String ip) {
		String country = "";
		String area = "";
		IPSeeker seeker = IPSeeker.getInstance();
		country = seeker.getCountry(ip);
		area = seeker.getArea(ip);
		return country + area;
	}
}
