package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.LoginService;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    //用户信息界面
    @RequestMapping("/userlist")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userService.selectUserAll();
        //
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("list",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","用户信息界面");



        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "userinfo";
    }
    @RequestMapping("/user/addUser")
    @ResponseBody
    public Msg insertUser(User user){
        int i=userService.addUser(user);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/getUserById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id){
        User user=userService.selectUserById(id);
        return Msg.success().add("user",user);

    }

    @RequestMapping("/user/deleteUserById/{id}")
    @ResponseBody

    public Msg deleteUserById(@PathVariable("id") Integer id, User user){
        int i=userService.deleteUserById(user);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/security")
    public String reg(Model model, Map<String,Object> top){

        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","personalActive");
        model.addAttribute("activeUrl2","securityActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","账户安全界面");

        return "user/personal/security";
    }
    @RequestMapping("/user/updatePwd")
    @ResponseBody
    public Msg updateUserpassword(User user){
        int i=userService.updateUserpassword(user);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    //用于退出页面
    //注销登录
    @RequestMapping("/logout")
    public String logout()
    {
        //System.out.println("logout");
        //session失效
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //修改登陆状态
        //public boolean updateAdminStatus(Integer id);  adminmapper
        // public boolean updateUserStatus(Integer id);  usermapper
        Integer userid = (Integer) session.getAttribute("loginUser");
        System.out.println(userid);
        userService.updateUserStatus1(userid);
        //销毁session
        session.stop();
        //重定向到登录页面


        return "redirect:/";
    }
    @RequestMapping("/adminexit")
    public String adminexit(){
        //取出当前用户session
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //修改登陆状态
        //public boolean updateAdminStatus(Integer id);  adminmapper
        // public boolean updateUserStatus(Integer id);  usermapper
        Integer adminid = (Integer) session.getAttribute("loginUser");
        System.out.println("adminid="+ adminid);
        loginService.updateAdminStatus(adminid);
        //销毁session
        session.stop();
        //重定向到登录页面
        return "redirect:/";
    }



}

