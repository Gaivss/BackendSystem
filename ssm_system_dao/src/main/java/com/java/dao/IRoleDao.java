package com.java.dao;

import com.java.domain.Permission;
import com.java.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 角色持久层
 * @author: Gakki
 * @create: 2020-11-03 00:16
 **/
public interface IRoleDao {
    /**
     * 登录权限查询
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,
                    many = @Many(select = "com.java.dao.IPermissionDao.findRoleByPermission"))
    }
    )
    List<Role> findRoleByUserId(String userId);

    /**
     * 查询全部角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void saveRole(Role role) throws Exception;


    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,
                    many = @Many(select = "com.java.dao.IPermissionDao.findRoleByPermission"))
    }
    )
    Role findById(String id) throws Exception;

    /**
     * 根据Id删除角色表中的角色
     */
    @Delete("Delete from role where id=#{id}")
    void deleteRoleById(String id) throws Exception;;

    /**
     * 删除角色用户表 中的角色
     * @param id
     */
    @Delete("Delete from role where id=#{id}")
    void deleteUser_RoleById(String id) throws Exception;;

    /**
     * 删除角色权限表 中的角色
     * @param id
     */
    @Delete("Delete from role where id=#{id}")
    void deleteRole_PermissionById(String id) throws Exception;

}
