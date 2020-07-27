package com.demo.pojo;

public class Change {
    private Integer id;
    private String name;
    private Double annualIncome;
    private String peiIncome;
    private String invesTerm;
    private String invesMoney;
    private Integer userId;
    private Integer changeMoneyId;

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    private Double profit;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChangeMoneyId() {
        return changeMoneyId;
    }

    public void setChangeMoneyId(Integer changeMoneyId) {
        this.changeMoneyId = changeMoneyId;
    }

    public String getInvesMoney() {
        return invesMoney;
    }

    public void setInvesMoney(String invesMoney) {
        this.invesMoney = invesMoney;
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


    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getPeiIncome() {
        return peiIncome;
    }

    public void setPeiIncome(String peiIncome) {
        this.peiIncome = peiIncome;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    @Override
    public String toString() {
        return "Change{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", annualIncome=" + annualIncome +
                ", peiIncome='" + peiIncome + '\'' +
                ", invesTerm='" + invesTerm + '\'' +
                ", invesMoney='" + invesMoney + '\'' +
                ", userId=" + userId +
                ", changeMoneyId=" + changeMoneyId +
                ", profit=" + profit +
                '}';
    }


    public Change(){

    }
}