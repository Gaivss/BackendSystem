package com.java.dao;

import com.java.domain.Member;
import com.java.domain.Orders;
import com.java.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.java.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws  Exception;


    /**
     * 根据ID查询
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.java.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class,
            one = @One(select = "com.java.dao.IMemberDao.findById")
            ),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,
            many = @Many(select = "com.java.dao.ITravellerDao.findTraveller"))
    })
    Orders findById(String id) throws Exception;
}
