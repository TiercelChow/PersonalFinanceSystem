package com.demo.mapper;


import org.apache.ibatis.annotations.*;
import com.demo.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from  user")
    public List<User> selectUserAll();

    @Insert("insert into user (username,password,realname,phone,email)values(#{username},#{password},#{realname},#{phone},#{email})")
    public int addUser(User user);

    @Select("select *from user where id=#{id}")
    public User selectUserById(Integer id);

    @Update("update user set IDcard=#{IDcard},paypwd=#{paypwd},realname=#{realname},phone=#{phone},email=#{email} where id=#{id}")
    public int  updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int deleteUserById(User user);

    @Update("update user set password=#{newpwd} where id=#{id}")
    public int updateUserpassword(User user);

    @Update("update user set status=1 where id=#{id}")
    public int  updateUserStatus(User user);

    @Update("update user set status=0 where id=#{id}")
    public int  updateUserStatus1(Integer id);

    @Update("update user set status=0 where id=#{id}")
    public int  updateUserStatus0(User user);
}
