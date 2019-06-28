package com.atguigu.atcrowdfunding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类 主要是 提供服务
 */

@SpringBootApplication // (exclude= {DataSourceAutoConfiguration.class})
//mapper 接口类扫描包配置
@MapperScan(basePackages = { "com.atguigu.atcrowdfunding.dao", "com.atguigu.atcrowdfunding.mapper","com.atguigu.atcrowdfunding.common.dao" })
public class AtcrowdfundingServiceSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(AtcrowdfundingServiceSystemApplication.class, args);
	}
}
