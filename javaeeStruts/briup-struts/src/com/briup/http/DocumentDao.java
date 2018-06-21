package com.briup.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 把爬取得url转换成img存入文件中
 *
 * @author xunfeng
 *
 */
public class DocumentDao {
	public void getValue(String fileUrl) throws Exception {
		File input = new File(fileUrl);
		Document doc = Jsoup.parse(input, "UTF-8");
		// 1.根据属性id值查，如<div id="footer">
		// Element content = doc.getElementById("footer");
		// 2.根据属性class值查，如<div class="h-top fr">
		// Elements eClass = doc.getElementsByClass("h-top fr");
		// 3.根据标签查，如<span/>
		// Elements tag = doc.getElementsByTag("span");
		// 4.根据属性名查，如<div ajaxurl="">
		// Elements footer = doc.getElementsByAttribute("ajaxurl");
		// System.out.println(footer);

		/**
		 * element.html()查询对象的html element.text()查询对象的文本内容
		 * element.text("a")为对象设置内容为a 
		 * element.className()获取属性class内的值
		 * element.id()获取属性id内的值，如<div id="min">,得到min
		 * element.attributes()获取所有属性 
		 * element.ownText()获取当前操作的对象内容
		 * element.attr("class")获取属性名为class的内的值
		 * element.tagName()获取标签名
		 */
		// Element element = doc.getElementById("mhtb0_c_0");
		// System.out.println(element.tagName());

		// Elements footer = doc.getElementsByAttribute("ajaxurl");
		// for (Element element : footer) {
		// if (element.tagName().equals("a")) {
		// System.out.println(element.html());
		// }
		// }
		
		/**
		 * 选择器语法
		 * select("a[href]") 查询带有href属性的a元素
		 * doc.select("img[src$=.jpg]") 查询扩展名为.png的图片
		 * select("#s-content") 通过id属性来查找 如id="s-content"
		 * select("[id]") 通过属性来查找 如<div id="">
		 */
		Elements elements = doc.select("div");
		System.out.println(elements);
		/*Elements img = doc.getElementsByTag("img");
		String http;
		String httpUrl;
		List<String> list = new ArrayList<>();
		for (Element element : img) {
			httpUrl = element.attr("src");
			http = httpUrl.substring(0, 4);
			if (http.equals("http")) {
				if (httpUrl.endsWith("jpg") || httpUrl.endsWith("png"))
					list.add(httpUrl);
			}
		}
		int i = 0;
		for (String string : list) {
			System.out.println(string);
			URL url = new URL(string);
			if (string.endsWith("jpg")) {
				inOrOutIn(url, "F:/java网络爬虫/网络爬虫img/"+i+".jpg");
			}else if(string.endsWith("png")){
				inOrOutIn(url, "F:/java网络爬虫/网络爬虫img/"+i+".png");
			}
			i++;
		}*/
	}
	public void inOrOutIn(URL url,String imgUrl) throws Exception{
		BufferedInputStream bReader = new BufferedInputStream(url.openStream());
		FileOutputStream fos = new FileOutputStream(imgUrl);
		BufferedOutputStream bWriter = new BufferedOutputStream(fos);
		byte[] bs = new byte[1024];
		int mString = 0;
		while ((mString = bReader.read(bs)) != -1) {
			bWriter.write(bs, 0, mString);
		}
		bWriter.flush();
		if (bReader != null)
			bReader.close();
		if (bWriter != null)
			bWriter.close();
	}
}
