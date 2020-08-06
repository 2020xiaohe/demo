package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.UserTest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hemb on 2020/8/6.
 */
public interface UserTestMapper {

    @Select("select id,name from user_test")
    List<UserTest> findAll();
}
