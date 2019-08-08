package com.atguigu.atcrowdfunding.desensitized.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.atguigu.atcrowdfunding.desensitized.enums.SensitiveTypeEnum;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Desensitized
 * @Copyright: Copyright (c) 2016
 * @Description: 敏感信息注解标记
 * @Company: lxjr.com
 * @Created on 2017-06-07 15:10:45
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {

    /*脱敏类型(规则)*/
    SensitiveTypeEnum type();

    /*判断注解是否生效的方法*/
    String isEffictiveMethod() default "";

}
