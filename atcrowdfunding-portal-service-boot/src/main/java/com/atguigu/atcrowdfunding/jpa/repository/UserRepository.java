package com.atguigu.atcrowdfunding.jpa.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.atguigu.atcrowdfunding.jpa.entity.User;

/**
 * 注意：
 * 1.这里这里是interface，不是class
 * 2.CrudRepository里面的泛型，第一个是实体类，第二个是主键的类型
 * 3.由于crudRepository 里面已经有一些接口了，如deleteAll，findOne等， 我们直接调用即可
 * 4.当然，我们也可以根据自己的情况来实现自己的接口,如下面的getUser()方法，jpql语句和hql语句差不多
 * */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * 我们这里只需要写接口，不需要写实现，spring boot会帮忙自动实现
     * 
     * */
    
    @Query("from User where id =:id ")
    public User getUser(@Param("id") Integer id);
}