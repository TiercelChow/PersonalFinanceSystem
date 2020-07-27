package com.demo.mapper;


import com.demo.pojo.MyFinance.UserChange;
import com.demo.pojo.MyFinance.UserFund;
import com.demo.pojo.MyFinance.UserPay;
import com.demo.pojo.MyFinance.UserTerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MyFinanceMapper {
    @Select("select user_change_money.id id,name,invesmoney,starttime,investerm,profit,averyield,status from user_change_money,change_money where userId=#{userId} and user_change_money.changeId = change_money.id")
    public List<UserChange> selectUserChangeByuserId(Integer userId);
    @Select("select user_pay_money.id id,type,monthmoney,starttime,investerm,profit,averyield,status from user_pay_money,pay_money where userId=#{userId} and user_pay_money.payId=pay_money.id")
    public List<UserPay> selectUserPayByuserId(Integer userId);

    @Select("SELECT user_term_financial.id id,name,leastmoney,starttime,investerm,user_term_financial.profit profit,averyield,status from user_term_financial,term_financial where userId=#{userId} and user_term_financial.termId=term_financial.id")
    public List<UserTerm> selectUserTermByuserId(Integer userId);
    @Select("SELECT user_fund_product.id id,funddesc,leastmoney,starttime,investerm,profit,averyield,status FROM user_fund_product,fund_product where userId=#{userId} and user_fund_product.fundId=fund_product.id")
    public List<UserFund> selectUserFundByuserId(Integer userId);
    @Update("update user_change_money set status=3 where id=#{userChangeMoneyId}")
    public int updateUserMoney(UserChange userChange);
    @Update("update user_pay_money set status=3 where id=#{userPayMoneyId}")
    public int updatePayMoney(UserPay userPay);
    @Update("update user_term_financial set status=3 where id=#{userTermFinancialId}")
    public int updateTermMoney(UserTerm userTerm);
    @Update("update user_fund_product set status=3 where id=#{userFundProductId}")
    public int updateFundMoney(UserFund userFund);
}
