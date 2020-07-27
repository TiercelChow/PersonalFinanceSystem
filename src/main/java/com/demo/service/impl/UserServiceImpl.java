package com.demo.service.impl;


import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();

    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    @Override
    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(User user) {
        return userMapper.deleteUserById(user);
    }

    @Override
    public int updateUserpassword(User user) {
        return userMapper.updateUserpassword(user);
    }

    @Override
    public int updateUserStatus(User user) {
        return userMapper.updateUserStatus(user);
    }

    @Override
    public int updateUserStatus1(Integer id) {
        return userMapper.updateUserStatus1(id);
    }

    @Override
    public int updateUserStatus0(User user) {
        return userMapper.updateUserStatus0(user);
    }


}