package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Permissions;
import com.demo.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class PermissionsController {
    @Autowired
    private PermissionsService permissionsService;


    @RequestMapping("/adminpermissions")
    public String SelectAdminPermission(Map<String,Object> top,
                                        Model model) {

//        设置侧边栏高亮
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","permissionActive");
        model.addAttribute("activeUrl2","adminPermissionsActive");
        top.put("pageTopBarInfo","管理员权限管理界面");


//        显示权限列表
        List<String> list = permissionsService.selectAdminPermissionsToString(1);
        model.addAttribute("permissionsList",list);
        return "admin/permission/adminpermissions";
    }

    @RequestMapping("/admin/updateAdminPermissions")
    @ResponseBody
    public Msg UpdateAdminPermission(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("adminPermissions");
        String[] strArray = str.split(";");
        //删除admin_permissions表中的所有数据
        permissionsService.deleteAdminPermissionsAll();
        int j=0;
        for(int i=0; i<strArray.length; i++) {
            //通过permission查询id
            Permissions adminPermissions = permissionsService.selectPermissionsIdByPermission(strArray[i]);
            //插入到admin_permissions表中
            j = permissionsService.insertAdminPermission(adminPermissions.getId());
            if(j==0)
                return Msg.fail();
        }
        return Msg.success();
    }


    /**
     * 用户界面
     * */
    @RequestMapping("/permissions")
    public String SelectUserPermission(Map<String,Object> top,
                                       Model model) {

//        设置侧边栏高亮
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","permissionActive");
        model.addAttribute("activeUrl2","userPermissionsActive");

        top.put("pageTopBarInfo","用户权限管理界面");


//        显示权限列表
        List<String> list = permissionsService.selectUserPermissionsToString(1);
        model.addAttribute("permissionsList",list);
        return "admin/permission/userpermissions";
    }

    @RequestMapping("/admin/updateUserPermissions")
    @ResponseBody
    public Msg UpdateUserPermission(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("userPermissions");
        String[] strArray = str.split(";");
        //删除user_permissions表中的所有数据
        permissionsService.deleteUserPermissionsAll();
        int j=0;
        for(int i=0; i<strArray.length; i++) {
            //通过permission查询id
            Permissions userPermissions = permissionsService.selectPermissionsIdByPermissionUser(strArray[i]);
            //插入到user_permissions表中
            j = permissionsService.insertUserPermission(userPermissions.getId());
            if(j==0)
                return Msg.fail();
        }
        return Msg.success();
    }
}
