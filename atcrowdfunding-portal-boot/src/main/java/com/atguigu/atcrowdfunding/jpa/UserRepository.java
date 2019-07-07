package com.atguigu.atcrowdfunding.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atguigu.atcrowdfunding.domain.User;

/**
 * Created on 2018/3/23.
 *
 * @author zlf
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User,Long>{
}