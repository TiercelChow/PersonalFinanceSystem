package com.demo.service.impl;

import com.demo.mapper.LoanMapper;
import com.demo.pojo.Loan;
import com.demo.pojo.MyFinance.UserLoan;
import com.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<Loan> selectLoanAll(){
        return loanMapper.selectLoanAll();
    }

    @Override
    public int updateLoan1(Loan loan) {
        return loanMapper.updateLoan1(loan);
    }

    @Override
    public int updateLoan2(Loan loan) {
        return loanMapper.updateLoan2(loan);
    }

    @Override
    public int addLoanApply(Loan loan) {
        return loanMapper.addLoanApply(loan);
    }

    @Override
    public List<UserLoan> selectLoanByuserId(Integer loanId) {
        return loanMapper.selectLoanByuserId(loanId);
    }

    @Override
    public int updateUserLoan(Loan loan) {
        return loanMapper.updateUserLoan(loan);
    }

    @Override
    public String SelectUserByLoanId(Integer loanId) {
        return loanMapper.SelectUserByLoanId(loanId);
    }

    @Override
    public Loan SelectLoneById(Integer id) {
        return loanMapper.SelectLoanById(id);
    }
}
