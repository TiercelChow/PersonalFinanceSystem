package com.demo.pojo;

public class Fund {
    private Integer id;
    private Integer type;
    private String code;
    private String funddesc;
    private Double dailygrowth;
    private Double monthlygrowth;
    private Double annualgrowth;
    private Double leastmoney;
    private String investerm;

    public Integer getId() {
        return id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFunddesc() {
        return funddesc;
    }

    public void setFunddesc(String funddesc) {
        this.funddesc = funddesc;
    }

    public Double getDailygrowth() {
        return dailygrowth;
    }

    public void setDailygrowth(Double dailygrowth) {
        this.dailygrowth = dailygrowth;
    }

    public Double getMonthlygrowth() {
        return monthlygrowth;
    }

    public void setMonthlygrowth(Double monthlygrowth) {
        this.monthlygrowth = monthlygrowth;
    }

    public Double getAnnualgrowth() {
        return annualgrowth;
    }

    public void setAnnualgrowth(Double annualgrowth) {
        this.annualgrowth = annualgrowth;
    }

    public Double getLeastmoney() {
        return leastmoney;
    }

    public void setLeastmoney(Double leastmoney) {
        this.leastmoney = leastmoney;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "id=" + id +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", funddesc='" + funddesc + '\'' +
                ", dailygrowth=" + dailygrowth +
                ", monthlygrowth=" + monthlygrowth +
                ", annualgrowth=" + annualgrowth +
                ", leastmoney=" + leastmoney +
                ", investerm='" + investerm + '\'' +
                '}';
    }
    public Fund(){

    }
}