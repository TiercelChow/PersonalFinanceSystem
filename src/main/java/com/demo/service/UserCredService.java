package com.demo.service;

import com.demo.pojo.UserCred;

import java.util.List;

public interface UserCredService {
    public List<UserCred> selectUserCredAll();

    public int updateUserCred(UserCred userCred);

    public UserCred selectUserCredById(Integer id);
}
