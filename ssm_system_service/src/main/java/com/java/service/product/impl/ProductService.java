package com.java.service.product.impl;


import com.gakki.util.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.java.dao.IProductDao;
import com.java.domain.Product;
import com.java.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 产品业务 实现类
 * @author: Gakki
 * @create: 2020-10-29 21:40
 **/
@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao ProductDao;

    @Override
    public List<Product> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return ProductDao.findAll();
    }

    @Override
    public Boolean deleteProduct(List<String> id) throws Exception {
        return ProductDao.deleteProduct(id);
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        product.setId(UUIDUtils.getUUID());
        ProductDao.saveProduct(product);
    }
}
