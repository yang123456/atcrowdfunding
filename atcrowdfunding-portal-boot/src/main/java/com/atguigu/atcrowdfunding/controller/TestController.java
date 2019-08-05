package com.atguigu.atcrowdfunding.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.domain.User;
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
    
    @RequestMapping("/query")
    @ResponseBody
    public String queryVerificationCode(String phone) {
    	String code = sendVerificationCode.queryVerificationCode(phone);
    	return code;
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
    
    @RequestMapping("/createUser")
    @ResponseBody
    public User time(User user) {
    	System.out.println(user);
    	return user;
    }
    

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor()); 
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
        binder.registerCustomEditor(String.class, "url", new StringEditor());
    }
    
    private class StringEditor extends PropertyEditorSupport {
    	@Override
    	public void setAsText(String text) throws IllegalArgumentException {
    		System.out.println("======StringEditor========="+text);
    	}
    }
    
    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
        	System.out.println("======MyDateEditor========="+text);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(text);
                } catch (ParseException e1) {
                }
            }
            setValue(date);
        }
    }
    
    public class DoubleEditor extends PropertiesEditor  {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException {    
        	System.out.println("======DoubleEditor========="+text);
            if (text == null || text.equals("")) {    
                text = "0";    
            }    
            setValue(Double.parseDouble(text));    
        }    
        
        @Override    
        public String getAsText() {    
            return getValue().toString();    
        }    
    }  
    
    public class IntegerEditor extends PropertiesEditor {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException {    
        	System.out.println("======IntegerEditor========="+text);
            if (text == null || text.equals("")) {    
                text = "0";    
            }    
            setValue(Integer.parseInt(text));    
        }    
        
        @Override    
        public String getAsText() {    
            return getValue().toString();    
        }    
    }  

    
}
