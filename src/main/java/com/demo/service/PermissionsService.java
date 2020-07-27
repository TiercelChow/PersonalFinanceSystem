package com.demo.service;

import com.demo.pojo.Permissions;

import java.util.List;

public interface PermissionsService {
    public List<Permissions> selectPermissions();
    public List<Permissions> selectAdminPermissionsByAdminId(Integer id);
    public List<String> selectAdminPermissionsToString(Integer id);
    public int deleteAdminPermissionsAll();
    public Permissions selectPermissionsIdByPermission(String permission);
    public int insertAdminPermission(Integer id);
    public List<Permissions> selectUserPermissionsByUserId(Integer id);
    public List<String> selectUserPermissionsToString(Integer id);
    public int deleteUserPermissionsAll();
    public Permissions selectPermissionsIdByPermissionUser(String permission);
    public int insertUserPermission(Integer id);
}
