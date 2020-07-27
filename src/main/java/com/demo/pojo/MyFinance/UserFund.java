package com.demo.pojo.MyFinance;

import java.util.Date;

public class UserFund {
    private Integer id;
    private String funddesc;
    private double leastmoney ;
    private Date starttime;
    private String investerm;
    private Double profit;
    private Double averyield;
    private int status;
    private Integer userId;
    private Integer fundProductId;
    private Integer userFundProductId;

    public Integer getUserFundProductId() {
        return userFundProductId;
    }

    public void setUserFundProductId(Integer userFundProductId) {
        this.userFundProductId = userFundProductId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunddesc() {
        return funddesc;
    }

    public void setFunddesc(String funddesc) {
        this.funddesc = funddesc;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFundProductId() {
        return fundProductId;
    }

    public void setFundProductId(Integer fundProductId) {
        this.fundProductId = fundProductId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserFund{" +
                "id=" + id +
                ", funddesc='" + funddesc + '\'' +
                ", leastmoney=" + leastmoney +
                ", starttime=" + starttime +
                ", investerm='" + investerm + '\'' +
                ", profit=" + profit +
                ", averyield=" + averyield +
                ", status=" + status +
                ", userId=" + userId +
                ", fundProductId=" + fundProductId +
                ", userFundProductId=" + userFundProductId +
                '}';
    }

    public UserFund(){

    }
}
