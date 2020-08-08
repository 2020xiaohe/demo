package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.ForgetPwdInfo;

public interface ForgetPwdInfoMapper {
    int deleteByPrimaryKey(Integer passwordId);

    int insert(ForgetPwdInfo record);

    int insertSelective(ForgetPwdInfo record);

    ForgetPwdInfo selectByPrimaryKey(Integer passwordId);

    int updateByPrimaryKeySelective(ForgetPwdInfo record);

    int updateByPrimaryKey(ForgetPwdInfo record);
}