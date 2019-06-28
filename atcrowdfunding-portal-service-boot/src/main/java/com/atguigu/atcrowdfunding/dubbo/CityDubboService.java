package com.atguigu.atcrowdfunding.dubbo;

import com.atguigu.atcrowdfunding.entity.City;

public interface CityDubboService {
	public City findCityByName(String cityName);
}
