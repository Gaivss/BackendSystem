package com.java.smm.controller;

import com.github.pagehelper.PageInfo;
import com.java.domain.Permission;
import com.java.service.permission.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 资源控制器
 * @author: Gakki
 * @create: 2020-11-04 13:45
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page",required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "page",required = true, defaultValue = "3" ) Integer size
    ) throws Exception {
        List<Permission> list = permissionService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String savePermission(Permission permission) throws Exception {
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }


}
