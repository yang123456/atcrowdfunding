package com.atguigu.atcrowdfunding.guava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.google.common.io.Resources;

public class Demo08 {
	public static void main(String[] args) throws IOException {
		String str = "1";
		// use java
		if (str != null && !str.isEmpty()) {
			System.out.println("java");
		}

		// use guava
		if (!Strings.isNullOrEmpty(str)) {
			System.out.println("guava");
		}

//		上而的例子还不是很给力，让我们举一个更给力的例子。[b]复制文件[/b]

//		File from = new File("D:\\image\\mq10.jpg");
//		File to = new File("D:\\image\\test.jpg");
//		// use java
//		FileInputStream in = new FileInputStream(from);
//		FileOutputStream out = new FileOutputStream(to);
//		byte[] buff = new byte[1024];
//		int readLength = -1;
//		while ((readLength = in.read(buff)) > 0) {
//			out.write(buff, 0, readLength);
//		}
//		in.close();
//		out.close();
//		// use guava
//		Files.copy(from, to); // 注意，只用了一行代码噢
		
		
		//将空字符串转换为null
        System.out.println( Strings.emptyToNull(""));
        //将null转换为空字符串
        System.out.println(Strings.nullToEmpty(null));
        //判断字符串为null或者为空
        System.out.println(Strings.isNullOrEmpty("") && Strings.isNullOrEmpty(null));
        //将字符串重复
        System.out.println(Strings.repeat("java", 3));
        
        System.out.println("===========");
        String source = "a1b2c3";
        CharMatcher matcher = CharMatcher.DIGIT; //预定义的 DIGIT 类型
        System.out.println( matcher.retainFrom(source));
        System.out.println( matcher.countIn(source));
        System.out.println( matcher.removeFrom(source));
        System.out.println( matcher.trimFrom("1a2b3c4"));
		
        System.out.println(Splitter.on(',').split("a,b")); //结果返回Iterable<String>,包含 "a" and "b"
        //将结果中的元素trim
        //结果依然包含  "a" 和 "b" ,而不是 "a " 和 " b"
        System.out.println(Splitter.on(',').trimResults().split("a , b")); 
        //忽略空字符串
        //结果必须是"a" 和 "b",而不是 "a" ,"" 和 "b"
        System.out.println(Splitter.on(',').omitEmptyStrings().split("a,,b")); 
        
     // helloGuava => HELLO_GUAVA
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "helloGuava"));
        // hello-guava => HelloGuava
        System.out.println( CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, "hello-guava"));
        
        int count=-1;
//        Preconditions.checkArgument(count > 0, "must be positive: %s", count);

        URL url = Resources.getResource("log4j.properties"); //获取classpath根下的config.xml文件url
		System.out.println(url.getContent());
	}
}
