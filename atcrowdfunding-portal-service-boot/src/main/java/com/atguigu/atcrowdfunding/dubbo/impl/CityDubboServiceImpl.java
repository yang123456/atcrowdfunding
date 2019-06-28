package com.atguigu.atcrowdfunding.dubbo.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.atcrowdfunding.dubbo.CityDubboService;
import com.atguigu.atcrowdfunding.entity.City;

//注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {
 
    public City findCityByName(String cityName) {
        return new City(1,"温岭");
    }
}