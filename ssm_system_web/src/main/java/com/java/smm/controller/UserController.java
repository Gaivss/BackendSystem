package com.java.smm.controller;

import com.gakki.util.UUIDUtils;
import com.github.pagehelper.PageInfo;
import com.java.domain.Orders;
import com.java.domain.Role;
import com.java.domain.UserInfo;
import com.java.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ssm_system
 * @description:
 * @author: Gakki
 * @create: 2020-11-03 21:56
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name="page",required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size",required = true, defaultValue = "3") Integer size
    ) throws Exception {
        List<UserInfo> userList = userService.findAll(page,size);
        ModelAndView mv = new ModelAndView();
        PageInfo<UserInfo> pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UserInfo user) throws Exception {
        userService.saveUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String id) throws Exception {
        UserInfo user = userService.findById(id);
        System.out.println(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("delete.do")
    public String deleteUser(@RequestParam(name = "id") String id) throws Exception{
        userService.deleteUser(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id") String id) throws Exception {
        //根据id查询用户
        UserInfo userInfo = userService.findById(id);
        //根据用户id 查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        System.out.println(otherRoles.size());
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "ids") String[] roleList) throws Exception {
        userService.addRoleToUser(userId,roleList);
        return "redirect:findAll.do";
    }

}
