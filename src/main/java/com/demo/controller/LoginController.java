package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Admin;
import com.demo.pojo.User;
import com.demo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    //登录界面
    @RequestMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg loginUsername(@PathVariable("username")String username, HttpServletRequest request){
        Admin admin=loginService.selectAdminByUsername(username);

        if(admin!=null){
            request.getSession().setAttribute("loginUser", admin.getId());
            request.getSession().setAttribute("username",admin.getUsername());
            return Msg.success();

        }else {
            User user=loginService.selectUserByUsername(username);
            if(user!=null){

                request.getSession().setAttribute("username",user.getUsername());
                request.getSession().setAttribute("loginUser", user.getId());
                request.getSession().setAttribute("loginPassword", user.getPassword());
                return Msg.success();

            }else {
                return Msg.fail();
            }
        }

    }



    @RequestMapping("/login/verifyLogin")
    @ResponseBody
    public Msg login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        //管理员登陆
/*        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin admin1 = loginService.adminLogin(admin);*/
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin admin1 = loginService.adminLogin(admin);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            if (admin1 != null) {
                Admin admin2=loginService.selectAdminByUsername(username);
                request.getSession().setAttribute("username", admin2.getUsername());
                return Msg.success().add("url", "/adminhead");
            } else {
                User user=loginService.selectUserByUsername(username);
                request.getSession().setAttribute("username",user.getUsername());
                    return Msg.success().add("url", "/new");
                }

        }catch(UnknownAccountException e) {
            System.out.println("用户名不存在");
            return Msg.fail();
        } catch(IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return Msg.fail();
        }
    }

}
