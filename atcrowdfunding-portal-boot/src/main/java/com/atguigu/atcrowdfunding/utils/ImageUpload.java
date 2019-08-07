package com.atguigu.atcrowdfunding.utils;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImageUpload {

	// 1.创建对应的MediaType
	private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
	private final static OkHttpClient client = new OkHttpClient();

	public  static String uploadImage(String userName, File file) throws IOException {
		// 2.创建RequestBody
		RequestBody fileBody = RequestBody.create(MEDIA_TYPE_PNG, file);

		// 3.构建MultipartBody
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("file", file.getName(), fileBody).addFormDataPart("userName", userName).build();

		// 4.构建请求
		Request request = new Request.Builder().url("http://xxxxx").post(requestBody).build();

		// 5.发送请求
		Response response = client.newCall(request).execute();
		
		return response.body().string();
	}
}
