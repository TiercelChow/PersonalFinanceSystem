package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public String reg(){
        return "register";
    }

    @RequestMapping("/login/register")
    @ResponseBody
    public Msg register(User user) {
        int i = registerService.addUser(user);
        if (i == 1) {
            return Msg.success().add("url","/");
        } else {
            return Msg.fail();
        }
    }
}
