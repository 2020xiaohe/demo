package com.ffcs.demo.controller;

import com.ffcs.demo.entity.UserTest;
import com.ffcs.demo.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hemb on 2020/8/6.
 */
@CrossOrigin
@RestController
@RequestMapping("/userTest")
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

    @GetMapping("/findAllByMybatis")
    public List<UserTest> findAll(){
        return userTestService.getUserTestMapper().findAll();
    }

}
