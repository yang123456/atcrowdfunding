package com.atguigu.atcrowdfunding.domain;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;

/**
 * Created on 2018/3/23.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Table(name = "h2_t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stuNo;
    private String name;
    private Double price;

    private String url;
    private Date birth;

    
}