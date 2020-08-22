package com.ffcs.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: TODO
 * @author: hemb
 * @date: 2020年08月22日 11:07
 */
@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "phone")
    private String userCount;

    @Column(name = "user_name")
    private String userName;
}
