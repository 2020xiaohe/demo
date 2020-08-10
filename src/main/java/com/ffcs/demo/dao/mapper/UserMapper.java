package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByIdPwd (@Param("userId") String userId , @Param("pwd")  String pwd);

    User selettById(String userId );

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



}