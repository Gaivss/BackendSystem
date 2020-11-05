package com.java.service.systemLog.impl;

import com.github.pagehelper.PageHelper;
import com.java.dao.ISysLogDao;
import com.java.domain.SysLog;
import com.java.service.systemLog.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 日志业务层
 * @author: Gakki
 * @create: 2020-11-05 21:49
 **/
@Service
@Transactional
public class SysLogService implements ISysLogService {

    @Autowired
    private ISysLogDao systemLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        systemLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return systemLogDao.findAll();
    }
}
