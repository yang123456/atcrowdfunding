package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;
import com.atguigu.atcrowdfunding.service.SendVerificationCode;

@Controller
public class TestController {
	
	@Autowired
	CityDubboConsumerService cityService;
	@Autowired
	SendVerificationCode sendVerificationCode;
	
    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello ,spring boot!";
    }
    
    @RequestMapping("/guava")
    @ResponseBody
    public boolean guava(String phone,String code) {
    	boolean flag = sendVerificationCode.saveVerificationCode(phone, code);
        return flag;
    }
    
    @RequestMapping("/dubbo")
    @ResponseBody
    public String dubbo() {
    	cityService.printCity();
        return "Hello ,spring dubbo!";
    }
    
    @RequestMapping("/time/{name}")
    @ResponseBody
    public String time(@PathVariable("name") String name) {
        return "time "+name;
    }
    
}
