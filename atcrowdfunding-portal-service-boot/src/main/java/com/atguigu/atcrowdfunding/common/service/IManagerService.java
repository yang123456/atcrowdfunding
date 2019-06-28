package com.atguigu.atcrowdfunding.common.service;

import java.util.List;

import com.atguigu.atcrowdfunding.domain.TManager;

/**
 * @Description: 管理员服务层接口
 * @Date: 2018/9/22 18:39
 * @Author: xyz
 */
public interface IManagerService {

    int deleteByPrimaryKey(Integer id);

    int insert(TManager manager);

    TManager selectByPrimaryKey(Integer id);

    List<TManager> selectAll();

    int updateByPrimaryKey(TManager manager);
}
