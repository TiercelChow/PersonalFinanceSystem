package com.demo.pojo;

public class Bank {
    private Integer id;
    private String name;
    private String type;
    private String assets;
    private String bankdesc;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getBankdesc() {
        return bankdesc;
    }

    public void setBankdesc(String bankdesc) {
        this.bankdesc = bankdesc;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", assets='" + assets + '\'' +
                ", bankdesc='" + bankdesc + '\'' +
                '}';
    }

    public Bank(){

    }
}
