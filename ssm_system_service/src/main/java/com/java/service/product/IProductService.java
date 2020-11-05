package com.java.service.product;

import com.java.domain.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查找全部
     * @return 产品集合
     * @throws Exception
     */
    List<Product> findAll(Integer page, Integer size) throws Exception;

    /**
     * 删除产品
     * @param id 主键
     * @return 是否成功删除
     * @throws Exception
     */
    Boolean deleteProduct(List<String> id) throws  Exception;

    /**
     * 保存产品
     * @param product
     * @throws Exception
     */
    void saveProduct(Product product) throws  Exception;
}
