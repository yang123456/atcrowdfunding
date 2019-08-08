package com.atguigu.atcrowdfunding.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.atcrowdfunding.entity.User;

@Controller
@RequestMapping("/ok")
public class OKhttpController {

	@RequestMapping("/hello")
	@ResponseBody
	public String home() {
		return "Hello , okhttp!";
	}

	@RequestMapping("/form")
	@ResponseBody
	public String form(String name, Integer age) {
		return name + "今年已经" + age + "岁了。";
	}

	@RequestMapping(value = "/postString", method = RequestMethod.POST)
	@ResponseBody
	public String postString(/* @RequestBody String str, */@RequestBody User user) {
//    	System.out.println("content中的内容>>>"+str);
		System.out.println("content中的内容>>>" + user);
		return "success";
	}
	/**
	 * 文件上传
	 * @param file
	 * @param userName
	 * @param model
	 * @param request
	 * @return
	 * @throws FileNotFoundException
	 */
	@PostMapping(value = "/fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam(value = "file") MultipartFile file, String userName, Model model,
			HttpServletRequest request) throws FileNotFoundException {
		if (file.isEmpty()) {
			System.out.println("文件为空");
		}

		File staticPath = new File(
				ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/', '\\'));// D:\github\atcrowdfunding\atcrowdfunding-portal-boot\target\classes\static
//        String filePath1 = request.getSession().getServletContext().getRealPath("imgupload/");//C:\Users\Administrator\AppData\Local\Temp\tomcat-docbase.8935896036701017699.8083\imgupload\
		if (!staticPath.exists()) {
			staticPath = new File("");
		}
		File upload2 = new File(staticPath.getAbsolutePath(), "upload/image/"); // 生成路径
		if (!upload2.exists()) {
			upload2.mkdirs();// 创建文件夹
		}
		String filePath = upload2.getAbsolutePath() + "/";

		String fileName = file.getOriginalFilename(); // 文件名
		String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
//        String filePath = "D://temp-file//"; // 上传后的路径
		fileName = UUID.randomUUID() + suffixName; // 新文件名
		File dest = new File(filePath + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String filename = "/temp-rainy/" + fileName;
//		model.addAttribute("filename", filename);
		return "上传成功";
	}

}
