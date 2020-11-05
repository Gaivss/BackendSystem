package com.java.dao;

import com.java.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    /**
     * 根据订单ID 查询中间表 查找旅客
     * @param id
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM traveller WHERE id IN "
            + "(SELECT travellerId FROM order_traveller WHERE orderId = #{id})")
    List<Traveller> findTraveller(String id) throws Exception;

}
