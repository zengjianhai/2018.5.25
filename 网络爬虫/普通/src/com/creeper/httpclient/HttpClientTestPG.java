package com.creeper.httpclient;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientTestPG {
	public static void main(String[] args) {
		// ��½ Url
        String loginUrl = "http://jwc.ecjtu.jx.cn/mis_o/main.php";
        // ���½����ʵ� Url
        String dataUrl = "http://jwc.ecjtu.jx.cn/mis_o/query.php";
        HttpClient httpClient = new HttpClient();
 
        // ģ���½����ʵ�ʷ�������Ҫ��ѡ�� Post �� Get ����ʽ
        PostMethod postMethod = new PostMethod(loginUrl);
 
        // ���õ�½ʱҪ�����Ϣ���û���������
        NameValuePair[] data = {new NameValuePair("StuID", "20142110011028") };
        postMethod.setRequestBody(data);
//        postMethod.setRequestHeader("Cookie", "PHPSESSID=phi41gnvet1luaeu56acorjk70");
        try {
            // ���� HttpClient ���� Cookie,���������һ���Ĳ���
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int statusCode=httpClient.executeMethod(postMethod);
            System.out.println(statusCode);     
            // ��õ�½��� Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpcookies.append(c.toString() + ";");
                System.out.println("cookies = "+c.toString());
            }
            if(statusCode==200){//�ض����µ�URL
                System.out.println("ģ���¼�ɹ�");
                // ���е�½��Ĳ���
                GetMethod getMethod = new GetMethod(dataUrl);
                // ÿ�η�������Ȩ����ַʱ�����ǰ��� cookie ��Ϊͨ��֤
                getMethod.setRequestHeader("Cookie", tmpcookies.toString());
                // �㻹����ͨ�� PostMethod/GetMethod ���ø�������������
                // ���磬referer ���������ģ�UA ���������涼������Լ���˭�����������������
                getMethod.setRequestHeader("Referer", "http://passport.mop.com/");
                getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
                httpClient.executeMethod(getMethod);
                // ��ӡ���������ݣ�����һ���Ƿ�ɹ�
                String text = getMethod.getResponseBodyAsString();
                System.out.println(text);
            }
            else {
                System.out.println("��¼ʧ��");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
