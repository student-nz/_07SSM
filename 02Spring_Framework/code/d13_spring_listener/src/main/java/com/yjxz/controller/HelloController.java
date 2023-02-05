package com.yjxz.controller;

import com.yjxz.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Date:2022/7/11
 * Author:ybc
 * Description:
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

}
