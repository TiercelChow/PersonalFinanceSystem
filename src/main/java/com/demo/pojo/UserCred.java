package com.demo.pojo;

public class UserCred {
    private Integer id;
    private String username;
    private String reputation;

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

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "UserCred{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", reputation='" + reputation + '\'' +
                '}';
    }
    public UserCred(){

    }
}
