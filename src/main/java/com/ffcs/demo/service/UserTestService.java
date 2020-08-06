package com.ffcs.demo.service;

import com.ffcs.demo.dao.mapper.UserTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hemb on 2020/8/6.
 */
@Service
public class UserTestService {

    @Autowired
    private UserTestMapper userTestMapper;

    public UserTestMapper getUserTestMapper() {
        return userTestMapper;
    }
}
