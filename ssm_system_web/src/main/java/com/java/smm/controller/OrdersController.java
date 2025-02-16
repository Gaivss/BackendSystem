package com.java.smm.controller;

import com.github.pagehelper.PageInfo;
import com.java.domain.Member;
import com.java.domain.Orders;
import com.java.service.orders.IOrdersService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 订单控制器
 * @author: Gakki
 * @create: 2020-11-01 01:47
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name="page",required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size",required = true, defaultValue = "4") Integer size) throws Exception {
         ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        PageInfo<Orders> pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
