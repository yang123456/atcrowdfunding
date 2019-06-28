package com.atguigu.atcrowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;

/**
 * Spring Boot 应用启动类
 *
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class AtcrowdfundingApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AtcrowdfundingApplication.class, args);
		
//		dubbo调用 服务
//        CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//        System.out.println(cityService);
//        cityService.printCity();
		
	}
}
