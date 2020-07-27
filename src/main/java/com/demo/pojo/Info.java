package com.demo.pojo;

import java.util.Date;

public class Info {
    private Integer id;
    private String username;
    private Integer sendId;
    private Integer receiveId;
    private Date createTime;
    private String title;
    private String infoDesc;
    private Integer status;

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

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", infoDesc='" + infoDesc + '\'' +
                ", status=" + status +
                '}';
    }

    public Info() {
    }
}
