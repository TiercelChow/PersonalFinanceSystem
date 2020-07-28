package com.demo.common.shiro;



import com.demo.pojo.Admin;
import com.demo.pojo.Permissions;
import com.demo.pojo.User;
import com.demo.service.LoginService;
import com.demo.service.PermissionsService;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    PermissionsService permissionsService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        String currentUserUsername = (String) subject.getPrincipal();
        User user = loginService.selectUserByUsername(currentUserUsername);
        if (user!=null){
            info.addRole("user");
            List<Permissions> list = permissionsService.selectUserPermissionsByUserId(1);
            for (Permissions up:list) {
                info.addStringPermission(up.getPermission());
            }
        }

        String currentAdminUsername = (String) subject.getPrincipal();
        Admin admin = loginService.selectAdminByUsername(currentAdminUsername);
        if (admin!=null){
            info.addRole("admin");
            List<Permissions> list = permissionsService.selectAdminPermissionsByAdminId(1);
            for (Permissions up:list) {
                info.addStringPermission(up.getPermission());
            }
        }


        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从token中取到用户名再去查用户密码
        //User user = userService.queryUserByName(userToken.getUsername());
        User user = loginService.selectUserByUsername(userToken.getUsername());
        if (user != null) {
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            user.setStatus(1);
            userService.updateUserStatus(user);
            session.setAttribute("loginUser1", user);
            System.out.println("执行了=>认证=>"+user.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "");
        }

        Admin admin = loginService.selectAdminByUsername(userToken.getUsername());
        if (admin!=null){
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            admin.setStatus(1);
            loginService.updateAdmin(admin);
            session.setAttribute("loginAdmin", admin);
            System.out.println("执行了=>认证=>"+admin.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),"");
        }
        return null;
    }
}
