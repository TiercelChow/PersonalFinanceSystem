package com.demo.mapper;


import com.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

    @Insert("insert into user (username,password)values(#{username},#{password})")
    public int addUser(User user);
}
