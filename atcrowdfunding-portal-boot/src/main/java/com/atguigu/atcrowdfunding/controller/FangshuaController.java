package com.atguigu.atcrowdfunding.controller;
import com.atguigu.atcrowdfunding.myannotation.AccessLimit;
import com.atguigu.atcrowdfunding.pojo.ApiReturnObject;
import com.atguigu.atcrowdfunding.pojo.ApiReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yhq
 * @date 2018/9/10 15:49
 */

@Controller
public class FangshuaController {

    @AccessLimit(seconds=5, maxCount=5, needLogin=true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public ApiReturnObject fangshua(){
        return ApiReturnUtil.success("请求成功");

    }
}