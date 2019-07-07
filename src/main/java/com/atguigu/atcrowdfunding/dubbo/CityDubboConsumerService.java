package com.atguigu.atcrowdfunding.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.atcrowdfunding.entity.City;

@Component
public class CityDubboConsumerService {
 
    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;
 
    public void printCity() {
        String cityName="温岭";
        System.out.println(cityDubboService);
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
