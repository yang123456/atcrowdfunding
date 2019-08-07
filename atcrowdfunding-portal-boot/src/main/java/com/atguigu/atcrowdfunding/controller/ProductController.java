package com.atguigu.atcrowdfunding.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.entity.ProductDto;
import com.atguigu.atcrowdfunding.myannotation.valid.RequestRequire;
import com.atguigu.atcrowdfunding.pojo.ApiReturnObject;
import com.atguigu.atcrowdfunding.pojo.ApiReturnUtil;

import lombok.extern.slf4j.Slf4j;
@RestController("/product")
@Slf4j
public class ProductController {
	
	@RequestRequire(require="supplierId,sku,state,name,unit,purchasePrice,storage",parameter = ProductDto.class)
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ApiReturnObject addSupplier(@RequestBody ProductDto productDto){
	    log.info(productDto.toString());
	    return ApiReturnUtil.ok();
	}
}
