package com.demo.mapper;


import com.demo.pojo.UserCred;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserCredMapper {
    @Select("select id,username,reputation from user")
    public List<UserCred> selectUserCredAll();

    @Update("update user set reputation = #{reputation} where id = #{id}")
    public int updateUserCred(UserCred userCred);

    @Select("select * from user where id = #{id}")
    public UserCred selectUserCredById(Integer id);



}
