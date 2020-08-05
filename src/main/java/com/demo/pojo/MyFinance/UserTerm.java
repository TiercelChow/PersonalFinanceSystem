package com.demo.pojo.MyFinance;

import java.util.Date;

public class UserTerm {
    private Integer id;
    private String name;
    private double leastmoney;
    private Date starttime;
    private String investerm;
    private Double profit;
    private Double averyield;
    private Integer userTermFinancialId;
    private Integer status;
    private Integer userId;
    private Integer termFinancialId;
    private String termname;

    public Integer getUserTermFinancialId() {
        return userTermFinancialId;
    }

    public void setUserTermFinancialId(Integer userTermFinancialId) {
        this.userTermFinancialId = userTermFinancialId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLeastmoney() {
        return leastmoney;
    }

    public void setLeastmoney(double leastmoney) {
        this.leastmoney = leastmoney;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getAveryield() {
        return averyield;
    }

    public void setAveryield(Double averyield) {
        this.averyield = averyield;
    }

    public Integer getTermFinancialId() {
        return termFinancialId;
    }

    public void setTermFinancialId(Integer termFinancialId) {
        this.termFinancialId = termFinancialId;
    }

    public String getTermname() {
        return termname;
    }

    public void setTermname(String termname) {
        this.termname = termname;
    }

    @Override
    public String toString() {
        return "UserTerm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leastmoney=" + leastmoney +
                ", starttime=" + starttime +
                ", investerm='" + investerm + '\'' +
                ", profit=" + profit +
                ", averyield=" + averyield +
                ", userTermFinancialId=" + userTermFinancialId +
                ", status=" + status +
                ", userId=" + userId +
                ", termFinancialId=" + termFinancialId +
                ", termname='" + termname + '\'' +
                '}';
    }

    public UserTerm(){

    }
}
