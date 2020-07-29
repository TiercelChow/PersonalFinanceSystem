package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.InfoService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    private InfoService infoService;
//个人信息界面
    @RequestMapping("/user/personal/profile")
    public String selectProfile(Model model, HttpServletRequest request, Map<String,Object> top){
        Integer profileId=(Integer)request.getSession().getAttribute("loginUser");
        User user= userService.selectUserById(profileId);
        model.addAttribute("user",user);
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","个人信息界面");
        return "user/personal/profile";
    }

    @RequestMapping("/user/updateUserProfile/{userId}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("userId") Integer id,User user) {
        user.setId(id);
        int i=userService.updateUser(user);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

}
