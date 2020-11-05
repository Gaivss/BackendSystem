package com.java.domain;

import com.gakki.util.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: ssm_system
 * @description: 订单实体类
 * @author: Gakki
 * @create: 2020-11-01 01:09
 **/
public class Orders {
    private String id;                           //主键
    private Product product;                     //产品id
    private String orderNum;                     //订单编号 唯一
    private String orderDesc;                   //订单描述

    private int orderStatus;                     // 订单状态(0 未支付 1 已支付)
    private String orderStatusStr;

    private Date orderTime;                      //订单创建时间
    private String orderTimeStr;

    private Integer payType;                    //支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;


    private int peopleCount;                     //出行人数
    private List<Traveller> travellers;          //可能有多个旅客
    private Member member;                      //旅客


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime != null){
            orderTimeStr = DateUtils.DateToString(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
//        支付方式(0 支付宝 1 微信 2其它)
        if(payType == 0){
            payTypeStr = "支付宝";
        }else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

//    订单状态(0 未支付 1 已支付)
    public String getOrderStatusStr() {
        if(orderStatus == 0){
            orderStatusStr = "未支付";
        }else if(orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }
}
