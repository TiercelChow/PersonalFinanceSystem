package com.demo.service;

import com.demo.pojo.Term;
import com.demo.pojo.MyFinance.UserTerm;

import java.util.List;

public interface TermService {
    public List<Term> selectTermAll();

    public int addTerm(Term term);
    public Term selectTermById(Integer id);
    public int  updateTerm(Term term);
    public int deleteTermById(Term term);
    public int addTermMoney(UserTerm userTerm);
}
