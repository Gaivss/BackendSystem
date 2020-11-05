package com.java.smm.controller;

import com.github.pagehelper.PageInfo;
import com.java.domain.Orders;
import com.java.domain.Product;
import com.java.service.product.IProductService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @program: ssm_system
 * @description: 控制器
 * @author: Gakki
 * @create: 2020-10-30 03:32
 **/
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查找全部
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
        @RequestParam(name="page",required = true, defaultValue = "1") Integer page,
        @RequestParam(name = "size",required = true, defaultValue = "3") Integer size) throws Exception {
            ModelAndView mv = new ModelAndView();
            List<Product> ProductList = productService.findAll(page,size);
            PageInfo<Product> pageInfo = new PageInfo(ProductList);
            mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product) throws Exception {
        productService.saveProduct(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("delete.do")
    public String deleteProduct(@RequestParam(name = "id") List<String> id) throws  Exception{
        productService.deleteProduct(id);
        return "redirect:findAll.do";
    }

    public String updataProduct(@RequestParam(name = "id") String id,Product product) throws Exception{
//        productService.updataProduct(id,product);
        return "redirect:findAll.do";
    }


}
