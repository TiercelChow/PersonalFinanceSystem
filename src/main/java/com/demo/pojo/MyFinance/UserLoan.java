package com.demo.pojo.MyFinance;

public class UserLoan {
    private Integer id;
    private Integer loanId;
    private double amount;
    private Integer term;
    private Double rate;
    private Integer applystatus;
    private Integer loanstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public Integer getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(Integer loanstatus) {
        this.loanstatus = loanstatus;
    }

    @Override
    public String toString() {
        return "UserLoan{" +
                "id=" + id +
                ", loanId=" + loanId +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", applystatus=" + applystatus +
                ", loanstatus=" + loanstatus +
                '}';
    }

    public UserLoan(){

    }
}
