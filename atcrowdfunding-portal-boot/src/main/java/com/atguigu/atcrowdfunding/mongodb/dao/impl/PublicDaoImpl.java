//package com.atguigu.atcrowdfunding.mongodb.dao.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Repository;
//
//import com.atguigu.atcrowdfunding.mongodb.dao.IPublicDao;
//
///**
// * @description:操作MongoDB文档复杂的功能，对mongoTemplate实现
// * @author:@luomouren.
// * @Date:2017-12-03 18:34
// */
//@Repository
//public class PublicDaoImpl<T> implements IPublicDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void update(Query query, Update update, Class T) {
//        mongoTemplate.updateMulti(query,update,T);
//    }
//}