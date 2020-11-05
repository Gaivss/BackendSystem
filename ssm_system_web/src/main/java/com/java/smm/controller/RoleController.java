package com.java.smm.controller;

import com.github.pagehelper.PageInfo;
import com.java.domain.Role;
import com.java.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ssm_system
 * @description: 角色控制器
 * @author: Gakki
 * @create: 2020-11-04 06:04
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(
          @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
          @RequestParam(name = "size", required = true, defaultValue = "3") Integer size
    ) throws Exception {
        List<Role> roleList = roleService.findAll(page,size);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String saveRole(Role role) throws Exception {
        roleService.saveRole(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String id) throws Exception {
        Role role = roleService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
    @RequestMapping("delete.do")
    public String deleteRole(@RequestParam(name = "id") String id) throws Exception {
        roleService.deleteRole(id);
        return "redirect:findAll.do";
    }
}
