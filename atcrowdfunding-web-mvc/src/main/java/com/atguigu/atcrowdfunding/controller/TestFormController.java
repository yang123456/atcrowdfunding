package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;

@Controller
@RequestMapping("/form")
public class TestFormController {

	@RequestMapping(value = "/index")
	public String index(String name, Integer age) {
		return "form/form1";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String get1(String name, Integer age) throws Exception {
		if(age!=null&&1==age) {
			throw new Exception();
		}
		System.out.println(name);
		System.out.println(age);
		Preconditions.checkArgument(StringUtils.isNotEmpty(name), "姓名不能为空");
		Preconditions.checkArgument(age>0, "%s 年龄不能小于0",age);
		Map map = new HashMap();
		map.put("username", "zhangsan");
		return "form/form1";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get2(String name, Integer age) {
		System.out.println(name);
		System.out.println(age);
		Preconditions.checkArgument(StringUtils.isNotEmpty(name), "姓名不能为空");
		Preconditions.checkArgument(age>0, "%s 年龄不能小于0",age);
		Map map = new HashMap();
		map.put("username", "zhangsan");
		return "form/form1";

	}

//	@ExceptionHandler(value = Exception.class)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) throws Exception {
		System.out.println("========局部controller捕获异常=====");
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e);
		mav.addObject("url", reqest.getRequestURL());
		mav.setViewName("exception");
		return mav;
	}

}
