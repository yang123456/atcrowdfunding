package com.atguigu.atcrowdfunding.configure;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atguigu.atcrowdfunding.filter.MyFilter;
import com.atguigu.atcrowdfunding.filter.TimeFilter;
import com.atguigu.atcrowdfunding.listener.MyListener;
import com.atguigu.atcrowdfunding.servlet.MyServlet;

@Configuration
public class MyConfigure {

	/**
	 * 配置嵌入式容器的一些基本配置
	 * 
	 * @return
	 */
//   @Bean
//   public EmbeddedServletContainerCustomizer  embeddedServletContainerCustomizer(){
//       return new EmbeddedServletContainerCustomizer() {
//           @Override
//           public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//               configurableEmbeddedServletContainer.setPort(8088);
//               //configurableEmbeddedServletContainer.setContextPath("/test");
//           }
//       };
//   }

	/**
	 * 注册自己编写的Servlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean myServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
		return servletRegistrationBean;
	}

	/**
	 * 注册自己编写的Filter拦截器
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MyFilter());
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/say1"));
		return filterRegistrationBean;

	}
	/**
	 * 注册自己编写的TimeFilter拦截器
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new TimeFilter());
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/time/*"));
		return filterRegistrationBean;
		
	}

	/**
	 * 注册自己编写的Listener监听器
	 * 
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean myListener() {
		ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<MyListener>(
				new MyListener());
		return servletListenerRegistrationBean;
	}

}
