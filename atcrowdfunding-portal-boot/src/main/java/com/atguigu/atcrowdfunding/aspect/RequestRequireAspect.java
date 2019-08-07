package com.atguigu.atcrowdfunding.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.atguigu.atcrowdfunding.myannotation.valid.RequestRequire;
import com.atguigu.atcrowdfunding.myannotation.valid.SetPropertyName;
import com.atguigu.atcrowdfunding.pojo.ApiReturnUtil;
/**
 * @ClassName: RequestRequireAspect
 * @Description: 参数校验的切面
 **/
@Component
@Aspect
public class RequestRequireAspect {


    static final String split = ",";

    @Pointcut("@annotation(com.atguigu.atcrowdfunding.myannotation.valid.RequestRequire)")
    public void controllerInteceptor() {
    	
    }

    /**
     * controller层增强类，用于检测参数为空的情况
     * @throws
     * @return java.lang.Object
     **/
    @Around("controllerInteceptor()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        // 获取注解的方法参数列表
        Object[] args = pjp.getArgs();

        // 获取被注解的方法
        MethodInvocationProceedingJoinPoint mjp = (MethodInvocationProceedingJoinPoint) pjp;
        MethodSignature signature = (MethodSignature) mjp.getSignature();
        Method method = signature.getMethod();

        // 获取方法上的注解
        RequestRequire require = method.getAnnotation(RequestRequire.class);

        // 以防万一，将中文的逗号替换成英文的逗号
        String fieldNames=require.require().replace("，", ",");

        // 从参数列表中获取参数对象
        Object parameter=null;
        for(Object pa:args){
            //class相等表示是同一个对象
            if (pa.getClass()==require.parameter() ) {
                parameter=pa;
            }
        }

        // 通过反射去和指定的属性值判断是否非空
        // 获得参数的class
        Class aClass = parameter.getClass();

        // 遍历参数，找到是否为空
        for(String name:fieldNames.split(split)){
            Field declaredField = aClass.getDeclaredField(name);
            String fieldName = declaredField.getName();
            declaredField.setAccessible(true);
            Object fieldObject = declaredField.get(parameter);
            // 获取属性的中文名称
            SetPropertyName spv = declaredField.getAnnotation(SetPropertyName.class);
            if(spv != null && StringUtils.isNotBlank(spv.value())){
                fieldName = spv.value();
            }

            if(fieldObject == null){
                return ApiReturnUtil.error("参数" + fieldName + "不能为空");
            }
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if (declaredField.getGenericType().toString().equals("class java.lang.String")) {
                if(StringUtils.isBlank((String)fieldObject)){
                    return ApiReturnUtil.error("参数" + fieldName + "不能为空");
                }
            }
            // 如果是数字类型的
/*           if (declaredField.getGenericType().toString().equals("class java.lang.Integer")
                  || declaredField.getGenericType().toString().equals("class java.lang.Long")
                   || declaredField.getGenericType().toString().equals("class java.lang.Double")
                  || declaredField.getGenericType().toString().equals("class java.lang.Float")) {
                if(fieldObject == null){
                    return R.error("参数" + fieldName + "不能为空");
               }
            } */
        }
        // 如果没有报错，放行
        return pjp.proceed();
    }
}
