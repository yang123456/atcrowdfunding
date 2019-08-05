package com.atguigu.atcrowdfunding.framework;

import com.atguigu.atcrowdfunding.framework.annotation.ExtClassPathAnnotationApplicationContext;
import com.atguigu.atcrowdfunding.service.ExtUserService;

/**
 * @Author 18011618
 * @Description
 * @Date 16:45 2018/6/18
 * @Modify By
 */
public class SpringIocAnnotationTest {
    public static void main(String[] args)throws Exception {
        String path = "com.atguigu.atcrowdfunding";
        ExtClassPathAnnotationApplicationContext context = new ExtClassPathAnnotationApplicationContext(path);
        ExtUserService userService = (ExtUserService) context.getBean("abc");
        System.out.println(userService.sayHello("zhangsan "));
    }
}
