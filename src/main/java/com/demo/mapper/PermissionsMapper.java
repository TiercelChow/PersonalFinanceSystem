package com.demo.mapper;


import com.demo.pojo.Permissions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionsMapper {
    /**
     * 管理员区
     * */


    //获取permissions表中所有数据
    @Select("select * from permissions")
    public List<Permissions> selectPermissions();
    //通过id获取管理员权限数据
    @Select("select * from permissions,admin_permissions where permissionId = permissions.id")
    public List<Permissions> selectAdminPermissionsByAdminId(Integer id);
    //通过id获取管理员权限数据(字符串类型)
    @Select("select permission from permissions,admin_permissions where permissionId = permissions.id")
    public List<String> selectAdminPermissionsToString(Integer id);

    //删除所有管理员权限
    @Delete("delete from admin_permissions where 1=1")
    public int deleteAdminPermissionsAll();

    //根据permission查询id
    @Select("select id from permissions where permission = #{permission}")
    public Permissions selectPermissionsIdByPermission(String permission);

    //向admin_permissions中添加数据
    @Insert("insert into admin_permissions(adminId,permissionId) values(1,#{id})")
    public int insertAdminPermission(Integer id);






    /**
     * 用户区
     * */

    //通过id获取用户权限数据
    @Select("select * from permissions,user_permissions where permissionId = permissions.id")
    public List<Permissions> selectUserPermissionsByUserId(Integer id);

    //通过id获取用户权限数据(字符串类型)
    @Select("select permission from permissions,user_permissions where permissionId = permissions.id")
    public List<String> selectUserPermissionsToString(Integer id);

    //删除所有用户权限
    @Delete("delete from user_permissions where 1=1")
    public int deleteUserPermissionsAll();

    //根据permission查询id
    @Select("select id from permissions where permission = #{permission}")
    public Permissions selectPermissionsIdByPermissionUser(String permission);

    //向user_permissions中添加数据
    @Insert("insert into user_permissions(userId,permissionId) values(1,#{id})")
    public int insertUserPermission(Integer id);
}
