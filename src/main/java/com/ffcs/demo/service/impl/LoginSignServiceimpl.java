package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.UserMapper;
import com.ffcs.demo.entity.User;
import com.ffcs.demo.service.LoginSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSignServiceimpl implements LoginSignService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selettById(String userId) {
        return userMapper.selettById(userId);
    }

    @Override
    public User selectByIdPwd(String userId, String pwd) {
        return userMapper.selectByIdPwd(userId,pwd);
    }
}
