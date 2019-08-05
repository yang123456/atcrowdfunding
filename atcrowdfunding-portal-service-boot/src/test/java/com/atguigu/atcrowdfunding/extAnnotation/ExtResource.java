package com.atguigu.atcrowdfunding.extAnnotation;

import java.lang.annotation.*;

/**
 * @Description 自定义属性的依赖注入
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExtResource {
	
}
