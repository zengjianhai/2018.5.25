package com.creeper.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaiduJsoup {
	public static void main(String[] args) {
		try {
			Connection.Response res = Jsoup.connect("http://jwc.ecjtu.jx.cn/mis_o/main.php")
					.method(Connection.Method.POST)
					.cookie("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=phi41gnvet1luaeu56acorjk70")
					.timeout(10000)
					.execute();
			Document doc = res.parse();
			Elements element = doc.getElementsByTag("body");
			for (int j = 0; j < element.size(); j++) {
				Element element2 = element.get(j);
				System.out.println(element2.html());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
