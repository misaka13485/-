package com.zengxuan.gateway.dto;

//ๆ้ๅ่กจ
public class AuthDto {
    private String status;
    private boolean admin;
    private boolean superAdmin;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean isSuperAdmin() {
        return superAdmin;
    }
    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }
}
