package com.atguigu.atcrowdfunding.http;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

/**
 * link com.atguigu.atcrowdfunding.controller.OKhttpController
 * 
 * @author Administrator
 *
 */
public class OKhttpTest {

	public static void main(String[] args) throws IOException {
		OKhttpTest oKhttpTest = new OKhttpTest();
//		oKhttpTest.testSyncOkHttp();
//		oKhttpTest.testAsyncOkHttp();
//		System.out.println("===================");
//		testpostFromParameters();
//		postStringParameters();
		fileUpload();
	}

	/**
	 * 同步get请求 同步请求会阻塞线程，并且不能运行在UI线程；
	 */
	private void testSyncOkHttp() throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder().url("http://localhost:8083/ok/hello").build();

		Response response = okHttpClient.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	/**
	 * 异步get请求 异步请求不会阻塞，也可以运行在UI线程，但是必须编写一个Callback;
	 */
	private void testAsyncOkHttp() {
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder().url("http://localhost:8083/ok/hello").get().build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println("onFailure;" + e.getLocalizedMessage());
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println("onResponse;" + response.body().string());
			}
		});
	}

	/**
	 * Post提交表单
	 */
	private static void testpostFromParameters() {
		String url = "http://localhost:8083/ok/form"; // 请求链接
		String name = "张三"; // 请求参数
		String age = "11"; // 请求参数
		OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
		RequestBody formBody = new FormBody.Builder().add("name", name).add("age", age).build(); // 表单键值对
		Request request = new Request.Builder().url(url).post(formBody).build(); // 请求
		okHttpClient.newCall(request).enqueue(new Callback() {// 回调

			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(response.body().string());// 成功后的回调
			}

			public void onFailure(Call call, IOException e) {
				System.out.println(e.getMessage());// 失败后的回调
			}
		});
	}

	/**
	 * Post提交字符串 使用Post方法发送一串字符串，但不建议发送超过1M的文本信息
	 */
	public static void postStringParameters() {
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		String url = "http://localhost:8083/ok/postString"; // 请求链接
		OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
		// 定义字符串
		String string = "[{'name':'toke','shuxue':'78','yuwen':'80'}," + "{'name':'seri','shuxue':'20','yuwen':'90'},"
				+ "{'name':'heer','shuxue':'99','yuwen':'56'}]";
//		String jsonString="{'username':admin,'password':'123456'}";
		String jsonString = "{'username':'lala','password':'123456'}";
//		String string = "key=9488373060c8483a3ef6333353fdc7fe"; // 要发送的字符串
		RequestBody requestBody = RequestBody.create(JSON, jsonString);
		/**
		 * RequestBody.create(MEDIA_TYPE, string)
		 * 第二个参数可以分别为：byte[]，byteString,File,String。
		 */
		Request request = new Request.Builder().url(url).post(requestBody).build();
		okHttpClient.newCall(request).enqueue(new Callback() {
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(response.body().string());
			}

			public void onFailure(Call call, IOException e) {
				System.out.println("失败:" + e.getMessage());
			}
		});
	}

	/**
	 * 文件上传
	 * @throws IOException 
	 */
	public static void fileUpload() throws IOException {
		// 1.创建对应的MediaType
		MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
		OkHttpClient client = new OkHttpClient();
		File file = new File("D:\\image\\mq10.jpg");
		// 2.创建RequestBody
		RequestBody fileBody = RequestBody.create(MEDIA_TYPE_PNG, file);

		// 3.构建MultipartBody
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("file", file.getName(), fileBody).addFormDataPart("userName", "张三").build();

		// 4.构建请求
		Request request = new Request.Builder().url("http://localhost:8083/ok/fileUpload").post(requestBody).build();

		// 5.发送请求
		Response response = client.newCall(request).execute();

		System.out.println(response.body().string());
	}

	/**
	 * 设置超时
	 * 
	 * @throws IOException
	 */
	public static void timeOutPost() throws IOException {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)// 设置链接超时
				.writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
				.readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
				.build();
		Request request = new Request.Builder().url("http://www.baidu.com/").build();

		Response response = client.newCall(request).execute();
		System.out.println("Response completed: " + response);
	}

	/**
	 * 缓存设置
	 * 
	 * @throws Exception
	 */
	public static void cachePost() throws Exception {
		File sdcache = new File("D:/file");
		int cacheSize = 10 * 1024 * 1024; // 10 MiB
		OkHttpClient client = new OkHttpClient.Builder().cache(new Cache(sdcache.getAbsoluteFile(), cacheSize)).build();
		Request request = new Request.Builder().url("http://localhost:8083/ok/hello").build();

		Response response1 = client.newCall(request).execute();
		if (!response1.isSuccessful())
			throw new IOException("Unexpected code " + response1);

		String response1Body = response1.body().string();
		System.out.println("Response 1 response:          " + response1);
		System.out.println("Response 1 cache response:    " + response1.cacheResponse());
		System.out.println("Response 1 network response:  " + response1.networkResponse());

		request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
		Response response2 = client.newCall(request).execute();
		if (!response2.isSuccessful())
			throw new IOException("Unexpected code " + response2);

		String response2Body = response2.body().string();
		System.out.println("Response 2 response:          " + response2);
		System.out.println("Response 2 cache response:    " + response2.cacheResponse());
		System.out.println("Response 2 network response:  " + response2.networkResponse());

		System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));
	}

	/**
	 * 复用OkHttpClient 所有HTTP请求的代理设置，超时，缓存设置等都需要在OkHttpClient中设置。 如果需要更改一个请求的配置，可以使用
	 * OkHttpClient.newBuilder()获取一个builder对象，
	 * 该builder对象与原来OkHttpClient共享相同的连接池，配置等。
	 */
	public static void shareClient() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("http://www.baidu.com/").build();

		try {
			// Copy to customize OkHttp for this request.
			OkHttpClient copy = client.newBuilder().readTimeout(500, TimeUnit.MILLISECONDS).build();
			Response response = copy.newCall(request).execute();
			System.out.println("Response 1 succeeded: " + response);
		} catch (IOException e) {
			System.out.println("Response 1 failed: " + e);
		}
		try {
			// Copy to customize OkHttp for this request.
			OkHttpClient copy = client.newBuilder().readTimeout(3000, TimeUnit.MILLISECONDS).build();
			Response response = copy.newCall(request).execute();
			System.out.println("Response 2 succeeded: " + response);
		} catch (IOException e) {
			System.out.println("Response 2 failed: " + e);
		}
	}

	/**
	 * OkHttp3处理验证 登录验证
	 * 
	 * @throws IOException
	 */
	public static void authenticatorPost() throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {

			public Request authenticate(Route route, Response response) throws IOException {
				System.out.println(response.challenges().toString());
				String credential = Credentials.basic("jesse", "password1");
				return response.request().newBuilder().addHeader("Authorization", credential).build();
			}
		}).build();
		Request request = new Request.Builder().url("http://publicobject.com/secrets/hellosecret.txt").build();
		Response response = okHttpClient.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

}
