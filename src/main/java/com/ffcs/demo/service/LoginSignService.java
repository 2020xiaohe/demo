package com.ffcs.demo.service;

import com.ffcs.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginSignService {

    int insertSelective(User record);

    User selettById(String userId);

    User selectByIdPwd(String userId, String pwd);

}
