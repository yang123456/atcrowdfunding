package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.enums.OperationType;
import com.atguigu.atcrowdfunding.enums.OperationUnit;
import com.atguigu.atcrowdfunding.myannotation.OperationLogDetail;
import com.atguigu.atcrowdfunding.service.TestAnnotationService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 *
 * @author weiwenjun
 * @date 2018/9/13
 */
@Service
public class TestAnnotationServiceImpl implements TestAnnotationService {

    @OperationLogDetail(detail = "通过手机号[{{tel}}]获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUserName(String tel) {
        System.out.println("tel:" + tel);
        return "zhangsan";
    }
}