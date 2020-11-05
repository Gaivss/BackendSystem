package com.java.domain;

/**
 * @program: ssm_system
 * @description: 联系人 会员实体类
 * @author: Gakki
 * @create: 2020-11-01 01:09
 **/
public class Member {
    private String id;              //id
    private String name;            //会员名字
    private String nickname;        //昵称
    private String phoneNum;        //手机号
    private String email;           //邮箱

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
