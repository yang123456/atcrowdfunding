package com.atguigu.atcrowdfunding.copyProperties;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;

public class Test {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		PersonA pa=new PersonA(1, "aaa", 13, "2018-11", "上海");
		PersonB pb=new PersonB();
		BeanUtils.copyProperties(pa,pb);
		System.out.println(pb);
		PersonB pb1=new PersonB(2, "bbb", "beijing");
		PersonA pa1=new PersonA();
		BeanUtils.copyProperties(pb1,pa1);
//		org.apache.commons.beanutils.BeanUtils.copyProperties(pa1,pb1);
		System.out.println(pa1);
		
		
//		PersonB pb2=new PersonB(2, "bbb", "daliann");
//		PersonB pb3=new PersonB(2, "ccc", "yunnan");
//		ArrayList<PersonB> pblist = Lists.newArrayList();
//		pblist.add(pb2);
//		pblist.add(pb3);
//		ArrayList<PersonA> palist = Lists.newArrayList();
//		org.apache.commons.beanutils.BeanUtils.copyProperties(palist,pblist);
//		System.out.println(palist);
		
		Map map=new HashMap();
		map.put("id", "99");
		map.put("name", "ggg");
		map.put("age", 199);
		org.apache.commons.beanutils.BeanUtils.populate(pa, map);//将map封装进javabean
		System.out.println(pa);
		
		Map describe = org.apache.commons.beanutils.BeanUtils.describe(pa);//把Bean的属性值放入到一个Map里面。
		System.out.println(describe);
		
		org.apache.commons.beanutils.BeanUtils.setProperty(pa, "name", "kaka");
		System.out.println(pa);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
