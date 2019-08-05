package com.atguigu.atcrowdfunding.framework;

import com.atguigu.atcrowdfunding.entity.UserEntity;
import com.atguigu.atcrowdfunding.framework.xml.ExtClassPathXmlApplicationContext;

/**
 * @Author 18011618
 * @Description
 * @Date 16:45 2018/6/18
 * @Modify By
 */
public class SpringIocXmlTest {
	public static void main(String[] args)throws Exception {
    	 ExtClassPathXmlApplicationContext classPathXmlApplicationContext = new ExtClassPathXmlApplicationContext("user.xml");
    	 UserEntity user = (UserEntity) classPathXmlApplicationContext.getBean("user1");
    	 System.out.println(user.getUserId() + "---" +user.getUserName());
    }
}
