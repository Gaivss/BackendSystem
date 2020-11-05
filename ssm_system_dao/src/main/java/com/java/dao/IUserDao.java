package com.java.dao;

import com.java.domain.Role;
import com.java.domain.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username} and password=#{password}")
    UserInfo login(String username, String password);

    @Select("select * from users where username=#{username}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.java.dao.IRoleDao.findRoleByUserId")) })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查找全部用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.java.dao.IRoleDao.findRoleByUserId")) })
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    @Insert("insert into users(id, email, username, password, phoneNum, status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status}) ")
    void saveUser(UserInfo user)throws Exception;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id=#{id}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.java.dao.IRoleDao.findRoleByUserId")) })
    UserInfo findUserById(String id) throws Exception;

    /**
     * 根据角色ID查找用户
     * @param roleId
     * @return
     */
    @Select("select * from users where id in (select userId from users_role where id = #{roleId})")
    List<UserInfo> findUserByRole(String roleId) throws Exception;

    /**
     * 删除用户
     * @param id
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUserById(String id) throws Exception;

    /**
     * 删除用户权限中间表的用户
     * @param id
     */
    @Delete("delete form users_role where id = #{id}")
    void deleteUserByUser_Role(String id) throws Exception;

    /**
     * 查询用户没有的角色
     * @param id
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<Role> findOtherRoles(String id);

    /**
     * 用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
