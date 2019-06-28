package com.atguigu.atcrowdfunding.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.common.dao.IManagerDao;
import com.atguigu.atcrowdfunding.common.service.IManagerService;
import com.atguigu.atcrowdfunding.domain.TManager;

/**
 * @Description: 管理员实现层
 * @Date: 2018/9/22 18:41
 * @Author: xyz
 */
@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    private IManagerDao managerDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int row = managerDao.deleteByPrimaryKey(id);
        return row;
    }

    @Override
    public int insert(TManager manager) {
        return managerDao.insert(manager);
    }

    @Override
    public TManager selectByPrimaryKey(Integer id) {
        return managerDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TManager> selectAll() {
        return managerDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(TManager manager) {
        return managerDao.updateByPrimaryKey(manager);
    }
}

