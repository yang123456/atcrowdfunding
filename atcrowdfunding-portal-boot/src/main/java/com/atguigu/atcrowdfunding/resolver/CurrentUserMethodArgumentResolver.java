package com.atguigu.atcrowdfunding.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.atguigu.atcrowdfunding.constants.CurrentUserConstants;
import com.atguigu.atcrowdfunding.domain.SysUser;
import com.atguigu.atcrowdfunding.myannotation.CurrentUser;

/**
 * @description:自定义解析器实现参数绑定
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @author:@luomouren.
 * @Date:2017-12-17 21:43
 */
//public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.getParameterType().isAssignableFrom(SysUser.class)
//            && parameter.hasParameterAnnotation(CurrentUser.class);//是否有@CurrentUser注解
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        SysUser user = (SysUser) webRequest.getAttribute(CurrentUserConstants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
//        if (user != null) {
//            return user;
//        }
//        throw new MissingServletRequestPartException(CurrentUserConstants.CURRENT_USER);
//    }
//}