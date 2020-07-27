package com.demo.mapper;


import com.demo.pojo.Term;
import com.demo.pojo.MyFinance.UserTerm;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TermMapper {
    @Select("select * from  term_financial")
    public List<Term> selectTermAll();

    @Insert("insert into term_financial (name,invesTerm,leastMoney,profit,annualIncome)values(#{name},#{invesTerm},#{leastMoney},#{profit},#{annualIncome})")
    public int addTerm(Term term);

    @Select("select *from term_financial where id=#{id}")
    public Term selectTermById(Integer id);

    @Update("update term_financial set name=#{name},leastMoney=#{leastMoney},profit=#{profit},invesTerm=#{invesTerm},annualIncome=#{annualIncome} where id=#{id}")
    public int  updateTerm(Term term);

    @Delete("delete from term_financial where id=#{id}")
    public int deleteTermById(Term term);

    @Insert("insert into user_term_financial (userId,termId,startTime,averYield,profit,status)values(#{userId},#{termFinancialId},CURDATE(),#{averyield},#{profit},1)")
    public int addTermMoney(UserTerm userTerm);
}
