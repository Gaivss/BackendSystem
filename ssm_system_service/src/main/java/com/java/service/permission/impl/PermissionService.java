package com.java.service.permission.impl;

import com.github.pagehelper.PageHelper;
import com.java.dao.IPermissionDao;
import com.java.domain.Permission;
import com.java.service.permission.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm_system
 * @description:
 * @author: Gakki
 * @create: 2020-11-04 13:40
 **/
@Service
@Transactional
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void savePermission(Permission permission) throws Exception {
        permissionDao.savePermission(permission);
    }
}
