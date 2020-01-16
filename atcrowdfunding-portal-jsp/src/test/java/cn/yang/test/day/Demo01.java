package cn.yang.test.day;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.sun.tools.javac.util.ArrayUtils;

public class Demo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		m1();
		
		System.out.println(6 % 7);
		System.out.println(6 % 3);
		System.out.println(6 % 5);

		System.out.println("============");

		System.out.println(0 % 7);
		System.out.println(1 % 7);
		System.out.println(3 % 7);
		System.out.println(5 % 7);
		System.out.println(7 % 7);
		System.out.println(8 % 7);

		String encode = URLEncoder.encode("localhost:8080/hello?name=zhangsan&msg=你好吗??", "UTF-8");
		System.out.println("编码:" + encode);
		String decode = URLDecoder.decode(encode, "UTF-8");
		System.out.println("解码:" + decode);

		// encodeURIComponent("localhost:8080/hello?name=zhangsan&msg=你好吗??")
//		"localhost%3A8080%2Fhello%3Fname%3Dzhangsan%26msg%3D%E4%BD%A0%E5%A5%BD%E5%90%97%3F%3F"
		String decode1 = URLDecoder.decode(
				"localhost%3A8080%2Fhello%3Fname%3Dzhangsan%26msg%3D%E4%BD%A0%E5%A5%BD%E5%90%97%3F%3F", "UTF-8");
		System.out.println(decode1);
	}
	
	public static void m1() {
		Object obj=null;
		if(null instanceof Object) {
			System.out.println("-=-=-===");
		}
		try {
			int i=1/0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("=====ddddd=========");
		}
	}
}
