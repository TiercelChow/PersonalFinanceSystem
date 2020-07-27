package com.demo.service;

import com.demo.pojo.Admin;
import com.demo.pojo.User;

public interface LoginService {
    public Admin selectAdminByUsername(String username);

    public Admin adminLogin(Admin admin);

    public User userLogin(User user);

    public User selectUserByUsername(String username);
    public int updateAdmin(Admin admin);
    public int  updateAdminStatus(Integer id);
}
