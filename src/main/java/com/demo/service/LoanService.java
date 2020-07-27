package com.demo.service;

import com.demo.pojo.Loan;
import com.demo.pojo.MyFinance.UserLoan;

import java.util.List;

public interface LoanService {
    public List<Loan> selectLoanAll();

    public int updateLoan1(Loan loan);
    public int updateLoan2(Loan loan);
    public int addLoanApply(Loan loan);
    public List<UserLoan> selectLoanByuserId(Integer loanId);
    public int updateUserLoan(Loan loan);
    public String SelectUserByLoanId(Integer loanId);
    public Loan SelectLoneById(Integer id);
}
