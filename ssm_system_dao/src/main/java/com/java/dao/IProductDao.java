package com.java.dao;


import com.java.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IProductDao {

    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

    /**
     * 查找全部
     * @return 产品集合
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 删除产品
     * @param id  产品 主键
     * @return 是否成功删除
     * @throws Exception
     */
    @Delete({"<script>",
            "delete from product where id in",
            "<foreach collection='list' item='id' open='(' close=')' separator=','>",
            "#{id}",
            "</foreach>",
            "</script>"}
    )
    Boolean deleteProduct(List<String> id) throws  Exception;


    /**
     * 保存产品
     * @param product   产品
     * @return
     * @throws Exception
     */

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    Integer saveProduct(Product product) throws Exception;


    /**
     * 更新产品
     * @param product
     * @return
     * @throws Exception
     */
    int updataProduct(Product product) throws  Exception;


}
