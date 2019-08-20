package com.atguigu.atcrowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot 应用启动类
 *
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class AtcrowdfundingViewApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AtcrowdfundingViewApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AtcrowdfundingViewApplication.class, args);
	}
}
