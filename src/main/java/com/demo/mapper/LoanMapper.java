package com.demo.mapper;

import com.demo.pojo.Loan;
import com.demo.pojo.MyFinance.UserLoan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LoanMapper {

    @Select("SELECT loan.id id,loanid,amount,term,reputation,applystatus,loanstatus,username," +
            "IDcard,phone FROM user,loan WHERE user.id = loan.loanid")
    public List<Loan> selectLoanAll();

    @Update({"UPDATE loan set applystatus=1,examineId=#{examineid} where id=#{id}"})
    public int updateLoan1(Loan loan);

    @Update({"UPDATE loan set applystatus=2,examineId=#{examineid} where id=#{id}"})
    public int updateLoan2(Loan loan);

    @Insert("INSERT INTO loan (loanid,amount,term,rate,applyStatus,loanStatus,loanTime) " +
            "VALUES (#{loanid},#{amount},#{term},#{rate},0,0,CURDATE())")
    public int addLoanApply(Loan loan);

    @Select("SELECT id,amount,term,rate,applystatus,loanstatus FROM loan WHERE loanId=#{userId} ")
    public List<UserLoan> selectLoanByuserId(Integer loanId);

    @Update({"UPDATE loan set loanstatus=2 where id=#{id}"})
    public int updateUserLoan(Loan loan);

    @Select("SELECT username FROM user WHERE id=#{loanId}")
    public String SelectUserByLoanId(Integer loanId);

    @Select("SELECT * FROM loan WHERE id=#{id}")
    public Loan SelectLoanById(Integer id);

}
