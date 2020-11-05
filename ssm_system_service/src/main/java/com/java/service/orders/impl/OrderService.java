package com.java.service.orders.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.IOrdersDao;
import com.java.domain.Orders;

import com.java.service.orders.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 订单业务层实现类
 * @author: Gakki
 * @create: 2020-11-01 01:40
 **/
@Service
@Transactional
public class OrderService implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page, Integer size) throws Exception {
        // pageNum 页码值     //pageSize 每页显示条数
        PageHelper.startPage(page,size);
        return  ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
