package com.atguigu.atcrowdfunding.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan
public class ViewResolverConfiguration extends WebMvcConfigurerAdapter {
    
       @Bean
       public ViewResolver viewResolver() {
    	   System.out.println("=======viewResolver=========");
           InternalResourceViewResolver resolver = new InternalResourceViewResolver();
           resolver.setPrefix("/WEB-INF/");
           resolver.setSuffix(".jsp");
           resolver.setViewNames("jsp/*");
           resolver.setOrder(2);
           return resolver;
       }

       @Bean
       public ITemplateResolver templateResolver() {
    	   System.out.println("=======templateResolver=========");
           SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
           templateResolver.setTemplateMode("HTML5");
           templateResolver.setPrefix("/WEB-INF/");
           templateResolver.setSuffix(".html");
           templateResolver.setCharacterEncoding("utf-8");
           templateResolver.setCacheable(false);
           return templateResolver;
       }

       @Bean
       public SpringTemplateEngine templateEngine() {
           SpringTemplateEngine templateEngine = new SpringTemplateEngine();
           templateEngine.setTemplateResolver(templateResolver());
           return templateEngine;
       }

       @Bean
       public ThymeleafViewResolver viewResolverThymeLeaf() {
    	   System.out.println("=======viewResolverThymeLeaf=========");
           ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
           viewResolver.setTemplateEngine(templateEngine());
           viewResolver.setCharacterEncoding("utf-8");
           viewResolver.setViewNames(new String[]{"thymeleaf/*","vue/"});
           viewResolver.setOrder(1);
           return viewResolver;
       }

       @Override
       public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
           configurer.enable();
       }

       @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           super.addResourceHandlers(registry);
       }
}