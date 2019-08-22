package com.atguigu.atcrowdfunding.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class ViewResolverController {

	public ViewResolverController() {
//        System.out.println("此时b还未被注入: b = " + b);
    }
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " /* + b */);
	}

	@RequestMapping("/index")
	public String index() {
		return "jsp/index";
	}

	@RequestMapping(value = { "/thymeleafindex.htm" })
	public String index(Model model) {
		return "templates/hello";
	}

	@RequestMapping(value = { "/thymeleaf" })
	public String index2(Model model) {
		return "thymeleaf/word";

	}

	@PreDestroy
	public void destroy() {
		System.out.println("======@PreDestroy=====");
	}

}