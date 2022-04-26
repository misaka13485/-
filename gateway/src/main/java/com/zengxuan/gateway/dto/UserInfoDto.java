package com.zengxuan.gateway.dto;

//用户信息dto
public class UserInfoDto {
    private int Id;
    private String username;
    private String password;
    private String identity;
    private AuthDto authDto;
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthDto getAuthDto() {
        return authDto;
    }

    public void setAuthDto(AuthDto authDto) {
        this.authDto = authDto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
