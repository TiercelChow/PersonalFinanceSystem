package com.demo.pojo;

public class Permissions {
    private Integer id;
    private String permission;
    private Integer adminId;
    private Integer permissionId;
    private Integer userId;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", adminId=" + adminId +
                ", permissionId=" + permissionId +
                ", userId=" + userId +
                '}';
    }

    public Permissions(){

    }
}
