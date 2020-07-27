package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.UserCred;
import com.demo.service.UserCredService;
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
public class UserCredController {
    @Autowired
    private UserCredService userCredService;


    @RequestMapping("/reputation")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<UserCred> list=userCredService.selectUserCredAll();
        //
        PageInfo<UserCred> pageInfo=new PageInfo<UserCred>(list);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","userInfoActive");
        model.addAttribute("activeUrl2","reputationActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","用户信誉界面");



        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "/admin/userinfo/reputation";
    }


    @RequestMapping("/user/updateUserCred/{id}")
    @ResponseBody
    public Msg updateUserCredProfile(@PathVariable("id") Integer id,UserCred userCred) {
        userCred.setId(id);
        int i=userCredService.updateUserCred(userCred);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
