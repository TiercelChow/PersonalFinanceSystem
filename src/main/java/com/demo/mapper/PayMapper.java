package com.demo.mapper;


import com.demo.pojo.Pay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PayMapper {
    @Select("select * from  pay_money")
    public List<Pay> selectPayAll();

    @Insert("insert into pay_money (monthMoney,autoInto,type,invesTerm)values(#{monthMoney},#{autoInto},#{type},#{invesTerm})")
    public int addPay(Pay pay);

    @Select("select *from pay_money where id=#{id}")
    public Pay selectPayById(Integer id);

    @Update("update pay_money set type=#{type},monthMoney=#{monthMoney},autoInto=#{autoInto},invesTerm=#{invesTerm} where id=#{id}")
    public int  updatePay(Pay pay);

    @Delete("delete from pay_money where id=#{id}")
    public int deletePayById(Pay pay);

    @Insert("insert into user_pay_money (userId,payId,startTime,averYield,profit,status)values(#{userId},#{payMoneyId},CURDATE(),0.031223000,#{profit},1)")
    public int addPayMoney(Pay pay);
}
