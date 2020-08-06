package com.ffcs.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hemb on 2020/8/2.
 */
@CrossOrigin
@RestController
@RequestMapping("api/helloWorld")
public class HelloWorldController {

    @CrossOrigin(origins = "*",allowCredentials = "true")
    @GetMapping("/sayHello")
    public  String helloWorld(){
        return "helloWorld";
    }
}
