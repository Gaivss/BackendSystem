package com.java.service.user;

import com.java.domain.Role;
import com.java.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户接口
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer size) throws Exception;

    void saveUser(UserInfo user) throws Exception;

    UserInfo findById(String id) throws Exception;

    void deleteUser(String id) throws  Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] roleList) throws Exception;
}
