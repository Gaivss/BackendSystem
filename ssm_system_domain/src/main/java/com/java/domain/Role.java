package com.java.domain;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 角色实体类
 * @author: Gakki
 * @create: 2020-11-02 18:10
 **/
public class Role {
    private String id;                                  //主键
    private String roleName;                            //角色名
    private String roleDesc;                            //角色描述
    private List<Permission> permissions;               //角色拥有的权限
    private List<UserInfo> userInfos;                          //拥有该角色的用户

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
