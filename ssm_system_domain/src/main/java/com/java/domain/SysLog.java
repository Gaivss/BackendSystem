package com.java.domain;

import java.util.Date;

/**
 * @program: ssm_system
 * @description: 日志实体类
 * @author: Gakki
 * @create: 2020-11-05 20:50
 **/
public class SysLog {
    private String id;
    private Date visitTime;             //访问时间
    private String visitTimeStr;
    private String username;            //操作者用户名
    private String ip;                  //访问者IP
    private String url;                 //访问资源URL
    private Long executionTime;         //执行的时长
    private String method;              //执行的方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
