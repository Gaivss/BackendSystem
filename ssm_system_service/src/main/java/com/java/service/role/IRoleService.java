package com.java.service.role;

import com.java.domain.Role;

import java.util.List;

public interface IRoleService {


    List<Role> findAll(Integer page, Integer size) throws Exception;

    void saveRole(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void deleteRole(String id) throws Exception;
}
