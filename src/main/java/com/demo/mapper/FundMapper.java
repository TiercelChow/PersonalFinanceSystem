package com.demo.mapper;


import com.demo.pojo.Fund;
import com.demo.pojo.MyFinance.UserFund;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FundMapper {
    @Select("select * from  fund_product")
    public List<Fund> selectFundAll();

    @Insert("insert into fund_product (type,code,funddesc,dailygrowth,monthlygrowth,annualgrowth,leastmoney,investerm)values(#{type},#{code},#{funddesc},#{dailygrowth},#{monthlygrowth},#{annualgrowth},#{leastmoney},#{investerm})")
    public int addFund(Fund fund);

    @Select("select *from fund_product where id=#{id}")
    public Fund selectFundById(Integer id);

    @Update("update fund_product set type=#{type},code=#{code},funddesc=#{funddesc},dailygrowth=#{dailygrowth},monthlygrowth=#{monthlygrowth},annualgrowth=#{annualgrowth},leastmoney=#{leastmoney},investerm=#{investerm} where id=#{id}")
    public int  updateFund(Fund fund);

    @Delete("delete from fund_product where id=#{id}")
    public int deleteFundById(Fund fund);

    @Insert("insert into user_fund_product (userId,fundId,startTime,averYield,profit,status)values(#{userId},#{fundProductId},CURDATE(),#{averyield},#{profit},1)")
    public int addFundMoney(UserFund userFund);

    @Insert("insert into flow_of_funds (userId,flowMoney,type,source,fundDesc,createTime) values(#{userId},#{leastmoney},1,#{name},#{fundname},CURDATE())")
    public  int insertFlowOfFund(UserFund userFund);
}
