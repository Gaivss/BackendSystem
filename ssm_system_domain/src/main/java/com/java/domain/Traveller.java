package com.java.domain;

/**
 * @program: ssm_system
 * @description: 旅客实体类
 * @author: Gakki
 * @create: 2020-11-01 01:10
 **/
public class Traveller {

    private String id;                      //主键
    private String name;                    //旅客名字
    private String sex;                     //旅客性别
    private String phoneNum;                //旅客电话号码
    private String credentialsNum;          //身份证号码

    private Integer credentialsType;        //证件类型 0身份证 1护照 2军官证
    private String credentialsTypeStr;

    private Integer travellerType;          //旅客类型(人群) 0 成人 1 儿童
    private String travellerTypeStr;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //证件类型 0身份证 1护照 2军官证
        if(credentialsType == 0){
            credentialsTypeStr = "身份证";
        }else if(credentialsType == 1){
            credentialsTypeStr = "护照";
        }else if(credentialsType == 2){
            credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        //旅客类型(人群) 0 成人 1 儿童
        if(this.travellerType == 0){
            this.travellerTypeStr = "成人";
        }else if(this.travellerType == 1){
            this.travellerTypeStr = "儿童";
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
