package com.demo.pojo.MyFinance;

import java.util.Date;

public class UserPay {
    private Integer id;
    private int type;
    private double monthmoney;
    private Date starttime;
    private String investerm;
    private double profit;
    private double averyield;
    private int status;
    private Integer userPayMoneyId;

    public Integer getUserPayMoneyId() {
        return userPayMoneyId;
    }

    public void setUserPayMoneyId(Integer userPayMoneyId) {
        this.userPayMoneyId = userPayMoneyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMonthmoney() {
        return monthmoney;
    }

    public void setMonthmoney(double monthmoney) {
        this.monthmoney = monthmoney;
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

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getAveryield() {
        return averyield;
    }

    public void setAveryield(double averyield) {
        this.averyield = averyield;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserPay{" +
                "id=" + id +
                ", type=" + type +
                ", monthmoney=" + monthmoney +
                ", starttime=" + starttime +
                ", investerm='" + investerm + '\'' +
                ", profit=" + profit +
                ", averyield=" + averyield +
                ", status=" + status +
                ", userPayMoneyId=" + userPayMoneyId +
                '}';
    }

    public UserPay(){

    }
}
