package com.atguigu.atcrowdfunding.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.atcrowdfunding.utils.FileUploadUtil;
import com.atguigu.atcrowdfunding.utils.ImgCut;
@Controller
@RequestMapping("/echarts")
public class EchartsController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String uploadHeadImage(HttpServletRequest request) throws Exception {
		return "echarts/index";
	}

	
}
