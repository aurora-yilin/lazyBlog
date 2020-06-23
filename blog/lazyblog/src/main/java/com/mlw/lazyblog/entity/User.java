package com.mlw.lazyblog.entity;

/**
 * @author oRuol
 * @Date 2020/6/23 15:58
 */
public class User {
    private int userId;
    private String password;
    private String userName;
    private String authority;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
