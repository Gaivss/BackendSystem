package com.java.service.role.impl;

import com.gakki.util.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.java.dao.IRoleDao;
import com.java.domain.Role;
import com.java.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 角色业务层
 * @author: Gakki
 * @create: 2020-11-04 06:01
 **/
@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void saveRole(Role role) throws Exception {
        role.setId(UUIDUtils.getUUID());
        roleDao.saveRole(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRole(String id) throws Exception {
        roleDao.deleteRole_PermissionById(id);
        roleDao.deleteUser_RoleById(id);
        roleDao.deleteUser_RoleById(id);
    }
}
