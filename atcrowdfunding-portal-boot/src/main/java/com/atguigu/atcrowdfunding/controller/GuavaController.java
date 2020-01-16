package com.atguigu.atcrowdfunding.controller;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;
import com.atguigu.atcrowdfunding.service.SendVerificationCode;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("guava")
public class GuavaController {



	LoadingCache<String, Map<String, String>> cache = CacheBuilder.newBuilder().newBuilder()
			.maximumSize(500).expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<String, Map<String, String>>() {
				@Override
				public Map<String, String> load(String key) throws Exception {
					Map<String, String> cacheMap = Maps.newHashMap();
					System.out.println("============"+key);
					cacheMap.put("name", "123");
					return cacheMap;
				}
			});

	@RequestMapping("/tests")
	@ResponseBody
	public String guava(String phone, String code) throws ExecutionException {
		Map<String, String> data = cache.get("data");
		String name = data.get("name");
		return name;
	}

}
