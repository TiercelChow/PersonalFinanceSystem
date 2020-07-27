package com.demo.mapper;


import com.demo.pojo.Change;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChangeMapper {
    @Select("select * from  change_money")
    public List<Change> selectChangeAll();

    @Insert("insert into change_money (name,annualIncome,peiIncome,invesTerm,invesMoney)values(#{name},#{annualIncome},#{peiIncome},#{invesTerm},#{invesMoney})")
    public int addChange(Change change);

    @Select("select *from change_money where id=#{id}")
    public Change selectChangeById(Integer id);

    @Update("update change_money set name=#{name},annualIncome=#{annualIncome},peiIncome=#{peiIncome},invesTerm=#{invesTerm},invesMoney=#{invesMoney} where id=#{id}")
    public int  updateChange(Change change);

    @Delete("delete from change_money where id=#{id}")
    public int deleteChangeById(Change change);

    @Insert("insert into user_change_money (userId,changeId,startTime,averYield,profit,status)values(#{userId},#{changeMoneyId},CURDATE(),#{annualIncome},#{profit},1)")
    public int addChangeMoney(Change change);
}
