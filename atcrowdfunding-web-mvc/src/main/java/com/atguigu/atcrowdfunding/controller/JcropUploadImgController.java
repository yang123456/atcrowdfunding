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
@RequestMapping("/upload")
public class JcropUploadImgController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String uploadHeadImage(HttpServletRequest request) throws Exception {
		return "jcrop/index";
	}

	@RequestMapping(value = "/uploadHeadImage", method = RequestMethod.POST)
	public String uploadHeadImage(HttpServletRequest request, @RequestParam(value = "x") String x,
			@RequestParam(value = "y") String y, @RequestParam(value = "h") String h,
			@RequestParam(value = "w") String w, @RequestParam(value = "imgFile") MultipartFile imageFile)
			throws Exception {
		System.out.println("==========Start=============");
		System.out.println("需要截取的坐标：X:>>" + x + ">>Y:>>" + y + ">>H:>>" + h + ">>W:>>" + w);
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String resourcePath = "resources/uploadImages/";
		if (imageFile != null) {
			if (FileUploadUtil.allowUpload(imageFile.getContentType())) {
				String fileName = FileUploadUtil.rename(imageFile.getOriginalFilename());
				int end = fileName.lastIndexOf(".");
				String saveName = fileName.substring(0, end);
				File dir = new File(realPath + resourcePath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				System.out.println("---文件保存目录--" + dir);
				File file = new File(dir, saveName + "_src.jpg");
				imageFile.transferTo(file);
				String srcImagePath = realPath + resourcePath + saveName;
				int imageX = Integer.valueOf(x);
				int imageY = Integer.valueOf(y);
				int imageH = Integer.valueOf(h);
				int imageW = Integer.valueOf(w);
				// 这里开始截取操作
				System.out.println("==========imageCutStart=============");
				ImgCut.imgCut(srcImagePath, imageX, imageY, imageW, imageH);
				System.out.println("==========imageCutEnd=============");
				request.getSession().setAttribute("imgSrc", resourcePath + saveName + "_src.jpg");// 成功之后显示用
				request.getSession().setAttribute("imgCut", resourcePath + saveName + "_cut.jpg");// 成功之后显示用
			}
		}
		return "jcrop/success";
	}
}
