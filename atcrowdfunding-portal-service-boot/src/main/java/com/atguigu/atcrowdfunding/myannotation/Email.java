package com.atguigu.atcrowdfunding.myannotation;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/**
 * @author zxiaofan 邮件地址,该注解只能String使用
 *1、定义@Email 注解
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
 

}