package com.java.dao;

import com.java.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    /**
     * 角色拥有的权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission where  id in (SELECT permissionId FROM role_permission WHERE roleId = #{roleId})")
    List<Permission> findRoleByPermission(String roleId)throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission values(#{id},#{PermissionName},#{url})")
    void savePermission(Permission permission) throws Exception;
}
