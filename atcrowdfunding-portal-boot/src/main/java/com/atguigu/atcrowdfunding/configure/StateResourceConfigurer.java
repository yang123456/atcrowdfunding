package com.atguigu.atcrowdfunding.configure;
/**
 如果将要访问的静态资源放在项目的类路径下面即配置为"classpath:/BookPicture/"那么当该路径下的资      源发生变化时是不立即生效的，即只有重启后才能访问到变化的资源；
 解决办法将静态资源放在非项目类路径下即可 "file:F:/bookpicture/");即下面这句
  registry.addResourceHandler("/bookpicture/**").addResourceLocations("file:C:/bookpicture/"); 
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StateResourceConfigurer extends WebMvcConfigurerAdapter {
	/**
	 * 配置访问静态资源
	 * @param registry
	 * "classpath:/static/"（暴露static下的文件夹给 “ /image/” 这个url）    http://localhost:8083/image/css/default.css
	 * "file:D:/temp-file/" （暴露d盘下的文件夹temp-file给 “ /image/ ”这个url）  //http://localhost:8083/image/66b4a96e-a63c-467a-abef-ddca05201094.jpg 访问的是d盘的66b4a96e-a63c-467a-abef-ddca05201094.jpg
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {   
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/","file:D:/temp-file/");
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
		super.addResourceHandlers(registry);
	}
}
