package com.demo.mapper;


import com.demo.pojo.Bank;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankMapper {
    @Select("select * from  bank")
    public List<Bank> selectBankAll();

    @Insert("insert into bank (name,type,assets,bankdesc)values(#{name},#{type},#{assets},#{bankdesc})")
    public int addBank(Bank bank);

    @Select("select *from bank where id=#{id}")
    public Bank selectBankById(Integer id);

    @Update("update bank set name=#{name},type=#{type},assets=#{assets},bankdesc=#{bankdesc} where id=#{id}")
    public int updateBank(Bank bank);

    @Delete("delete from bank where id=#{id}")
    public int deleteBankById(Bank bank);
}
