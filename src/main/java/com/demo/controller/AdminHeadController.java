package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AdminHeadController {
    @Autowired
    private UserService userService;

    @RequestMapping("/adminhead")
    public String selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                Model model,Map<String,Object> top)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userService.selectUserAll();
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","系统首页");



        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "/admin/main";
    }
    @RequestMapping("/admin/updateUserStatus/{id}")
    @ResponseBody
    public Msg updateUserStatus(@PathVariable("id") Integer id, User user) {
        user.setId(id);
        int i=userService.updateUserStatus0(user);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
