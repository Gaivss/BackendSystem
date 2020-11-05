package com.java.service.orders;

import com.java.domain.Orders;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 订单业务层
 * @author: Gakki
 * @create: 2020-11-01 01:39
 **/
public interface IOrdersService  {

    List<Orders> findAll(Integer page, Integer size) throws  Exception;

    Orders findById(String id) throws  Exception;
}
