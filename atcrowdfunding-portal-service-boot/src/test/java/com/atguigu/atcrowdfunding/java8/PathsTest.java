package com.atguigu.atcrowdfunding.java8;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;

public class PathsTest {

	public static void main(String[] args) {
		//以当前路径作为Path对象
        Path p = Paths.get(".");
        //使用传入的字符串返回一个Path对象
        Path p2 = Paths.get("D","ReviewIO","URL");
        //对应的路径
        System.out.println("p对象的对应路径：" + p.toString());
        System.out.println("p2对象的对应路径：" + p2.toString());
        //路径数量是以路径名的数量作为标准
        System.out.println("p路径数量：" + p.getNameCount());
        System.out.println("p2路径数量：" + p2.getNameCount());        
        //获取绝对路径
        System.out.println("p绝对路径：" + p.toAbsolutePath());
        System.out.println("p2绝对路径：" + p2.toAbsolutePath());
        //获取父路径
        System.out.println("p父路径："  + p.getParent());
        System.out.println("p2父路径：" + p2.getParent());
        //获取p2对象的文件名或者文件目录名
        System.out.println(p2.getFileName());
        //通过Path对象返回一个分隔符对象
        Spliterator<Path> split = p2.spliterator();
        
        System.out.println("2141241##52352".replace("#", "@"));
        
	}

}
