package com.demo.pojo;

public class Loan {
    private Integer id;
    private Integer loanid;
    private Integer examineid;
    private String loanTime;
    private Double amount;
    private Integer term;
    private Double rate;
    private Integer applystatus;
    private Integer loanstatus;
    private String username;
    private String reputation;
    private String IDcard;
    private String phone;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getExamineid() {
        return examineid;
    }

    public void setExamineid(Integer examineid) {
        this.examineid = examineid;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanid=" + loanid +
                ", examineid=" + examineid +
                ", loanTime='" + loanTime + '\'' +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", applystatus=" + applystatus +
                ", loanstatus=" + loanstatus +
                ", username='" + username + '\'' +
                ", reputation='" + reputation + '\'' +
                ", IDcard='" + IDcard + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Loan() {
    }
}
