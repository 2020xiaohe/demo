package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer rolemenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer rolemenuId);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}