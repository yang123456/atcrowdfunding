package com.atguigu.atcrowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.common.service.IManagerService;
import com.atguigu.atcrowdfunding.domain.TManager;

/**
 * @Description: 管理员访问控制层
 * @Date: 2018/9/22 18:46
 * @Author: xyz
 */
@RestController
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    /**
     * @Description: 添加管理员，返回添加数量
     * @MethodName: insert
     * @param: manager
     * @ReturnType: int
     */
    @PostMapping(value = "/manager/insert")
    public int insert(TManager manager) {
        return managerService.insert(manager);
    }

    /**
     * @Description: 根据id删除管理员，返回删除数量
     * @MethodName: deleteByPrimaryKey
     * @param: id
     * @ReturnType: int
     */
    @PostMapping(value = "/manager/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestParam(value = "id", required = true) Integer id) {
        int row = managerService.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * @Description: 根据id更改管理员信息, 返回更改数量
     * @MethodName: updateByPrimaryKey
     * @param: manager
     * @ReturnType: int
     */
    @PostMapping(value = "/manager/updateByPrimaryKey")
    public int updateByPrimaryKey(TManager manager) {
        return managerService.updateByPrimaryKey(manager);
    }

    /**
     * @Description: 查询单个管理员对象
     * @MethodName: selectByPrimaryKey
     * @param: id
     * @ReturnType: com.xyz.mapper.entity.TManager
     */
    @PostMapping(value = "/manager/selectByPrimaryKey")
    public TManager selectByPrimaryKey(Integer id) {
        return managerService.selectByPrimaryKey(id);
    }

    /**
     * @Description: 查询所有管理员不分页
     * @MethodName: selectAll
     * @param:
     * @ReturnType: java.util.List<com.xyz.mapper.entity.TManager>
     */
    @PostMapping(value = "/manager/selectAll")
    public List<TManager> selectAll() {
        List<TManager> managerList = managerService.selectAll();
        return managerList;
    }
}

