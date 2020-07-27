package com.demo.mapper;


import com.demo.pojo.Admin;
import com.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper {
    @Select("select * from admin where username=#{username}")
    public Admin selectAdminByUsername(String username);

    @Select("select * from admin where username=#{username} and password=#{password}")
    public Admin adminLogin(Admin admin);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User userLogin(User user);

    @Select("select * from user where username=#{username}")
    public User selectUserByUsername(String username);

    @Update("update admin set status=1 where id=#{id}")
    public int updateAdmin(Admin admin);

    @Update("update admin set status=0 where id=#{id}")
    public int  updateAdminStatus(Integer id);

}
