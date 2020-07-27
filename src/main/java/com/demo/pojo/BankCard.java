package com.demo.pojo;

public class BankCard {
    private Integer id;
    private Integer userId;

    private String username;
    private String cardBank;
    private Integer type;
    private String cardNum;

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", cardBank='" + cardBank + '\'' +
                ", type='" + type + '\'' +
                ", cardNum='" + cardNum + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public BankCard(){

    }
}
