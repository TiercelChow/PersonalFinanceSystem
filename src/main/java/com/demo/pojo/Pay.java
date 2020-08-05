package com.demo.pojo;

public class Pay {
    private Integer id;
    private Double monthMoney;
    private Integer autoInto;
    private Integer type;
    private String invesTerm;
    private Integer userId;
    private Integer payMoneyId;
    private Double profit;
    private String payname;
    private String name;

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getPayMoneyId() {
        return payMoneyId;
    }

    public void setPayMoneyId(Integer payMoneyId) {
        this.payMoneyId = payMoneyId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



    public Double getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(Double monthMoney) {
        this.monthMoney = monthMoney;
    }

    public Integer getAutoInto() {
        return autoInto;
    }

    public void setAutoInto(Integer autoInto) {
        this.autoInto = autoInto;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", monthMoney=" + monthMoney +
                ", autoInto=" + autoInto +
                ", type=" + type +
                ", invesTerm='" + invesTerm + '\'' +
                ", userId=" + userId +
                ", payMoneyId=" + payMoneyId +
                ", profit=" + profit +
                ", payname='" + payname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Pay(){

    }
}