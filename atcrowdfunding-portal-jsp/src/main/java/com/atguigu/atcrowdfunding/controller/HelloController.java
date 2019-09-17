package com.atguigu.atcrowdfunding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	String home(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("name", "张三");
		redirectAttributes.addAttribute("age", 14);
		redirectAttributes.addFlashAttribute("sex", "男");// 重定向页面时有用
		return "redirect:/hello2";
	}

	@RequestMapping("/hello2")
	@ResponseBody
	String home2(RedirectAttributes redirectAttributes, String name, Integer age, String sex) {
		System.out.println("=======redirectAttributes获取的属性值====" + name + " |  " + age + " |  " + sex);
		return name + "是个" + sex + "孩子，已经" + age + "岁了..";
	}

	@RequestMapping("/home3")
	public String home3(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "请输入账号！");
		return "redirect:/home";
	}

}
