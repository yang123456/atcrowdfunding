package com.atguigu.atcrowdfunding.myannotation.valid;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 第二步：再增加一个注解@SetPropertyName 这个注解的主要目的是为了非空检查返回属性的中文信息
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SetPropertyName {

    String value() default "";
}
