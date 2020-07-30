package com.demo.mapper;


import com.demo.pojo.BankCard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankCardMapper {
    @Select("SELECT bankcard.id id,username,cardBank,type,cardNum FROM user,bankcard WHERE user.id = bankcard.userId")
    public List<BankCard> selectBankCardAll();

    @Update("UPDATE bankcard set cardBank=#{cardBank},type=#{type},cardNum=#{cardNum} WHERE id=#{id}")
    public int updateBankCard(BankCard bankCard);

    @Select("SELECT username,cardBank,type,cardNum FROM user,bankcard WHERE user.id = bankcard.userId and bankcard.id = #{id}")
    public BankCard selectGetBankCardById(Integer id);

    @Delete("delete from bankcard where id= #{id}")
    public int deleteBankCard(BankCard bankCard);
    @Select("SELECT id,cardBank,type,cardNum FROM bankcard WHERE userId=#{userId}")
    public List<BankCard> selectBankCardById(Integer userId);

    @Insert("insert into bankcard (cardBank,type,cardNum,userId)values(#{cardBank},#{type},#{cardNum},#{userId})")
    public int insertBankCard(BankCard bankCard);

    @Select("SELECT cardBank,type,cardNum FROM bankcard WHERE id = #{id}")
    public BankCard selectUserBankCardById(Integer id);

    @Update("UPDATE bankcard set cardBank=#{cardBank},type=#{type},cardNum=#{cardNum} WHERE id=#{id}")
    public int updateUserBankCard(BankCard bankCard);


    @Delete("delete from bankcard where id= #{id}")
    public int deleteUserBankCard(BankCard bankCard);

}

