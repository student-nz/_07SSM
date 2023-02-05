package com.yj.nz.spring.controller;

import com.yj.nz.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class UserController {

    //@Autowired(required = false)
    //@Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    /*public UserController(UserService userService) {
        this.userService = userService;
    }*/

    /*public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){
        userService.saveUser();
    }

}
