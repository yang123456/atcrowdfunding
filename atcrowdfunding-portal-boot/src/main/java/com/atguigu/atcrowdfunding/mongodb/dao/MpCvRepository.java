//package com.atguigu.atcrowdfunding.mongodb.dao;
//
//import java.util.Optional;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import com.atguigu.atcrowdfunding.mongodb.bean.MpCv;
//
//
///**
// * @description:查询MongDB中mpcv历史抄表示数
// * 基本的增删改查功能jpa已经实现了，直接在service调用就行。一些复杂的功能我们可以写一个通用的dao类由mongoTemplate实现。
// * @author:@luomouren.
// * @Date:2017-11-30 23:43
// */
//public interface MpCvRepository extends MongoRepository<MpCv, String> {
//    /**
//     * 根据主键查找抄表记录
//     * @param id 抄表记录主键
//     * @return
//     */
//    Optional<MpCv> findById(String id);
//}