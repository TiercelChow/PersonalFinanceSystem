package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//调用
public class TestController {
    //@Controller C @Service M UserServiceImpl  new spring  类  new  类

    @RequestMapping("/")// RequestMapping 请求的路径  post get
    public String test(){
        return "login";

    }
}
