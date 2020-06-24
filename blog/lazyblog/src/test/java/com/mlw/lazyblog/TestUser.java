package com.mlw.lazyblog;

/**
 * @author oRuol
 * @Date 2020/6/24 19:26
 */
public class TestUser {
    private int userId;
    private String password;
    private String userName;
    private String userAuthority;
    private String mail;

    @Override
    public String toString() {
        return "TestUser{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userAuthority='" + userAuthority + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

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

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
