package com.java.domain;

import com.gakki.util.DateUtils;
import com.gakki.util.UUIDUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: ssm_system
 * @description: 产品信息实体类
 * @author: Gakki
 * @create: 2020-10-29 21:19
 **/

public class Product {

    private String id;                //  主键

    private String productNum;          //  编号 唯一

    private String productName;         //  名称

    private String cityName;            // 出发城市

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureTime;         //  出发时间

    private String departureTimeStr;    //

    private double productPrice;        //  产品价格

    private String productDesc;         //  产品描述

    private Integer productStatus;      //  状态 0关闭  1开启

    private String productStatusStr;    //

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr = DateUtils.DateToString(departureTime,"yyyy-MM-dd HH:mm:ss");
        }

        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            if(productStatus == 0){
                productStatusStr = "关闭";
            }else if(productStatus == 1){
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
