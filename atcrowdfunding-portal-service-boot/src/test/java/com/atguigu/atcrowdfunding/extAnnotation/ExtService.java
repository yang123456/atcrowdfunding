package com.atguigu.atcrowdfunding.extAnnotation;

import java.lang.annotation.*;

/**
 * @Description 自定义服务的依赖注入
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtService {
    String name() default "";
}
