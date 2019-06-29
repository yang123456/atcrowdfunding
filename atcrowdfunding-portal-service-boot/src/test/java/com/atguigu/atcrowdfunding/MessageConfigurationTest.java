package com.atguigu.atcrowdfunding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.atcrowdfunding.config.MessageConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * 自定义配置文件测试类
 * Spring Boot MessageConfiguration 测试 - {@link MessageConfiguration}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConfigurationTest {

    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        assertEquals("message configuration", ctx.getBean("message"));
        System.out.println(ctx.getBean("message"));
    }

    @Test
    public void testScanPackages() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.atguigu.atcrowdfunding.config");
        ctx.refresh();
        assertEquals("message configuration", ctx.getBean("message"));
        System.out.println(ctx.getBean("message"));

    }
}
