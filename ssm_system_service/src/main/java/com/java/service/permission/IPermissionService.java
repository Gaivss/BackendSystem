package com.java.service.permission;

import com.java.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll(Integer page,Integer size) throws Exception;

    void savePermission(Permission permission) throws Exception;
}
