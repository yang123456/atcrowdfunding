package com.atguigu.atcrowdfunding.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.atcrowdfunding.domain.SysUser;
import com.atguigu.atcrowdfunding.mongodb.bean.MpCv;
import com.atguigu.atcrowdfunding.myannotation.CurrentUser;
import com.atguigu.atcrowdfunding.myannotation.LoginRequired;
import com.atguigu.atcrowdfunding.service.MpCvService;
import com.atguigu.atcrowdfunding.service.SysUserService;

/**
 * @description:
 * @author:@luomouren.
 * @Date:2017-12-03 16:53
 */
@RestController
@RequestMapping({"/mpCv"})
public class MpCvController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MpCvService mpCvService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SysUserService sysUserServices;
    @LoginRequired
    @RequestMapping(value = "save")
    @ResponseBody
    public String save() {
        String cvId = "cvId";
        String mpId = "mpId";
        Double value = 12.1230;
        Date dataTime = new Date();
        Date samTime = new Date();
        MpCv mpCv = new MpCv(UUID.randomUUID() + "", cvId, mpId, value, dataTime, samTime);
        mongoTemplate.save(mpCv);
        return "";
    }
    
    @ResponseBody
    @RequestMapping(value = "/registeredUser")
    public Object registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description) {
        logger.info("registeredUser:userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",password" + password + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.registeredUser(userName, realName, cellphone, emodelId, password, email, description);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/modifyUserPassword")
    public Object modifyUserPassword(String userId, String oldPassword, String newPassword) {
        JSONObject jsonObject = sysUserServices.modifyUserPassword(userId, oldPassword, newPassword);
        return jsonObject;
    }


    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/modifyUserInfo")
    public Object modifyUserInfo(@CurrentUser SysUser user, String userId, String userName, String realName, String cellphone, String emodelId,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "description", required = false) String description) {
        logger.info(user.getUserName());
        logger.info("registeredUser:userId:" + userId + ",userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.modifyUserInfo(userId, userName, realName, cellphone, emodelId, email, description);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/resetUserPassword")
    public Object resetUserPassword(String userId, String newPassword) {
        JSONObject jsonObject = sysUserServices.resetUserPassword(userId, newPassword);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/getUserInfo")
    public Object getUserInfo(@CurrentUser SysUser user) {
        return user;
    }

}