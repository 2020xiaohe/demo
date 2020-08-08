package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.Dic;

public interface DicMapper {
    int deleteByPrimaryKey(Integer dicsId);

    int insert(Dic record);

    int insertSelective(Dic record);

    Dic selectByPrimaryKey(Integer dicsId);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}