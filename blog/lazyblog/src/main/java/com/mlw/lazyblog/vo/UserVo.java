package com.mlw.lazyblog.vo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author oRuol
 * @Date 2020/7/1 15:01
 */
public class UserVo {
    private String userName;
    private Collection userAuthority;
    private String email;
    private String headImage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(ArrayList userAuthority) {
        this.userAuthority = userAuthority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", userAuthority='" + userAuthority + '\'' +
                ", email='" + email + '\'' +
                ", headImage='" + headImage + '\'' +
                '}';
    }
}
