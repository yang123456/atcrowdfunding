package com.atguigu.atcrowdfunding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;

/**
 * Spring Boot 应用启动类
 *
 */
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan("com.atguigu.atcrowdfunding.mapper")
@EnableScheduling
public class AtcrowdfundingApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AtcrowdfundingApplication.class, args);
		
//		dubbo调用 服务
//        CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//        System.out.println(cityService);
//        cityService.printCity();
		
	}
}
