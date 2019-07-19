package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.service.TestAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA
 *
 * @author weiwenjun
 * @date 2018/9/12
 */
@Controller
@RequestMapping("anno")
public class TestAnnotationController {

    @Autowired
    private TestAnnotationService testAnnotationService;

    /**
     * 访问路径 http://localhost:11000/anno/findUserNameByTel?tel=1234567
     * @param tel 手机号
     * @return userName
     */
    @ResponseBody
    @RequestMapping("/findUserNameByTel")
    public String findUserNameByTel(@RequestParam("tel") String tel){
        return testAnnotationService.findUserName(tel);
    }
}