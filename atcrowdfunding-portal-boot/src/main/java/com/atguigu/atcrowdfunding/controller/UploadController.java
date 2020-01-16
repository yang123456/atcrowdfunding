/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.atguigu.atcrowdfunding.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.atcrowdfunding.domain.Upload;
import com.atguigu.atcrowdfunding.utils.FileUploadUtils;

/**
 * 文件上传/下载
 * Version: 1.0
 */
@Controller
@RequestMapping(value = "file/upload")
public class UploadController {

	@GetMapping(value = "/index")
	public String create(Model model, HttpServletRequest request) {
		
		return "file-upload";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Model model, HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@Valid @ModelAttribute("m") Upload upload, BindingResult result, RedirectAttributes redirectAttributes)  {
		System.out.println("=======UploadController========="+file);
//		 int i=5;
//		 i=i/0;
		if (!file.isEmpty()) {
			upload.setSrc(FileUploadUtils.upload(request, file, result));
		}
		return "file-upload";
	}

}
