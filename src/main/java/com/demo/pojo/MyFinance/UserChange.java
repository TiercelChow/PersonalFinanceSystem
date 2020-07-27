package com.demo.pojo.MyFinance;

import java.util.Date;

public class UserChange {
    private Integer id;
    private String name;
    private double invesmoney;
    private Date starttime;
    private String investerm;
    private double profit;
    private double averyield;
    private int status;
    private Integer userChangeMoneyId;

    public Integer getUserChangeMoneyId() {
        return userChangeMoneyId;
    }

    public void setUserChangeMoneyId(Integer userChangeMoneyId) {
        this.userChangeMoneyId = userChangeMoneyId;
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

    public double getInvesmoney() {
        return invesmoney;
    }

    public void setInvesmoney(double invesmoney) {
        this.invesmoney = invesmoney;
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
        return "UserChange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", invesmoney=" + invesmoney +
                ", starttime=" + starttime +
                ", investerm='" + investerm + '\'' +
                ", profit=" + profit +
                ", averyield=" + averyield +
                ", status=" + status +
                ", userChangeMoneyId=" + userChangeMoneyId +
                '}';
    }

    public UserChange(){

    }
}
