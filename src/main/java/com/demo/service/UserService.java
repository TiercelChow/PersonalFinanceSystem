package com.demo.service;

import com.demo.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> selectUserAll();


    public int addUser(User user);


    public User selectUserById(Integer id);

    public int  updateUser(User user);

    public int deleteUserById(User user);

    public int updateUserpassword(User user);

    public int  updateUserStatus(User user);

    public int  updateUserStatus1(Integer id);

    public int  updateUserStatus0(User user);
}
