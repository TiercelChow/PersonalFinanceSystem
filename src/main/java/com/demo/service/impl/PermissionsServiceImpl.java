package com.demo.service.impl;


import com.demo.mapper.PermissionsMapper;
import com.demo.pojo.Permissions;
import com.demo.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    @Autowired
    private PermissionsMapper permissionsMapper;


    @Override
    public List<Permissions> selectPermissions() {
        return permissionsMapper.selectPermissions();
    }

    @Override
    public List<Permissions> selectAdminPermissionsByAdminId(Integer id) {
        return permissionsMapper.selectAdminPermissionsByAdminId(id);
    }

    @Override
    public List<String> selectAdminPermissionsToString(Integer id) {
        return permissionsMapper.selectAdminPermissionsToString(id);
    }

    @Override
    public int deleteAdminPermissionsAll() {
        return permissionsMapper.deleteAdminPermissionsAll();
    }

    @Override
    public Permissions selectPermissionsIdByPermission(String permission) {
        return permissionsMapper.selectPermissionsIdByPermission(permission);
    }

    @Override
    public int insertAdminPermission(Integer id) {
        return permissionsMapper.insertAdminPermission(id);
    }

    @Override
    public List<Permissions> selectUserPermissionsByUserId(Integer id) {
        return permissionsMapper.selectUserPermissionsByUserId(id);
    }

    @Override
    public List<String> selectUserPermissionsToString(Integer id) {
        return permissionsMapper.selectUserPermissionsToString(id);
    }

    @Override
    public int deleteUserPermissionsAll() {
        return permissionsMapper.deleteUserPermissionsAll();
    }

    @Override
    public Permissions selectPermissionsIdByPermissionUser(String permission) {
        return permissionsMapper.selectPermissionsIdByPermissionUser(permission);
    }

    @Override
    public int insertUserPermission(Integer id) {
        return permissionsMapper.insertUserPermission(id);
    }
}
