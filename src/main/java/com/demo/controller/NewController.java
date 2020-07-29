package com.demo.controller;


import com.demo.pojo.New;
import com.demo.service.NewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class NewController {
    @Autowired
    private NewService newService;

//系统首页
    @RequestMapping("/new")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<New> list=newService.selectNewAll();
        //
        PageInfo<New> pageInfo=new PageInfo<New>(list);
        model.addAttribute("newsList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","系统首页");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/main";
    }
}
