package com.atguigu.atcrowdfunding.page.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atguigu.atcrowdfunding.jpa.entity.User;

/**
 * 用户持久层操作接口
 *
 * Created by bysocket on 18/09/2017.
 */
@Repository
public interface PageUserRepository extends PagingAndSortingRepository<User, Long> {

}
