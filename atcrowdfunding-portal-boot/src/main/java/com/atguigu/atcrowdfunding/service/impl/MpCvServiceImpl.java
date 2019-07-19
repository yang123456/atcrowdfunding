//package com.atguigu.atcrowdfunding.service.impl;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//
//import com.atguigu.atcrowdfunding.mongodb.bean.MpCv;
//import com.atguigu.atcrowdfunding.mongodb.dao.IPublicDao;
//import com.atguigu.atcrowdfunding.mongodb.dao.MpCvRepository;
//import com.atguigu.atcrowdfunding.service.MpCvService;
//
///**
// * @description:保存历史抄表示数
// * @author:@luomouren.
// * @Date:2017-12-03 16:45
// */
//@Service
//public class MpCvServiceImpl implements MpCvService {
//    @Autowired
//    private MpCvRepository mpCvRepository;
//    @Autowired
//    private IPublicDao<MpCv> publicDao;
//
//    @Override
//    public void save(MpCv mpCv) {
//        mpCvRepository.save(mpCv);
//    }
//
//
//    @Override
//    public void updateValueByCvIdAndDataTime(String cvId, Date dataTime, String value) {
//        // 查询条件
//        Query query = new Query();
//
//        Criteria cvIdCriteria = new Criteria("cvId");
//        cvIdCriteria.is(cvId);
//        query.addCriteria(cvIdCriteria);
//
//        Criteria dataTimeCriteria = new Criteria("dataTime");
//        dataTimeCriteria.is(dataTime);
//        query.addCriteria(dataTimeCriteria);
//        // 更新语句
//        Update update = Update.update("value", value);
//        publicDao.update(query, update, MpCv.class);
//    }
//}