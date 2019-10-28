package com.atguigu.atcrowdfunding.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/lottery")
public class LotteryController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String uploadHeadImage(HttpServletRequest request) throws Exception {
		return "lottery/index";
	}

}
