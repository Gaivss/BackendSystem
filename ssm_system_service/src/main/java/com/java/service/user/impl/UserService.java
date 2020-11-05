package com.java.service.user.impl;

import com.gakki.util.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.java.dao.IUserDao;
import com.java.domain.Role;
import com.java.domain.UserInfo;
import com.java.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ssm_system
 * @description:
 * @author: Gakki
 * @create: 2020-11-03 00:15
 **/
@Service("userService")
@Transactional
class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user;
        //0 为用户未开启 1其用户开启
        if(userInfo.getStatus() == 1){
            user = new User(userInfo.getUsername(), userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        }else{
            user = new User(userInfo.getUsername(),userInfo.getPassword(),false,true,true,true,getAuthority(userInfo.getRoles()));
        }
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roleList){
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    /**
     * 查找全部用户
     * @param page    页码
     * @param size    每页数
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    @Override
    public void saveUser(UserInfo user) throws Exception {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(UUIDUtils.getUUID());
        if(user.getStatusStr().equals("开启")){
            user.setStatus(1);
        }else{
            user.setStatus(0);
        }
        userDao.saveUser(user);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findUserById(id);
    }

    @Override
    public void deleteUser(String id) throws Exception {
        userDao.deleteUserById(id);
    }

    @Override
    public List<Role> findOtherRoles(String id) {
        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleList) throws Exception {
        for(String roleId:roleList){
            userDao.addRoleToUser(userId,roleId);
        }
    }


}
