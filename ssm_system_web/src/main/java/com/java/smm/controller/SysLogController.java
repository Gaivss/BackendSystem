package com.java.smm.controller;

import com.github.pagehelper.PageInfo;
import com.java.domain.SysLog;
import com.java.service.systemLog.ISysLogService;
import com.java.service.systemLog.impl.SysLogService;
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
 * @create: 2020-11-05 22:03
 **/
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name="page",required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size",required = true, defaultValue = "3") Integer size) throws Exception {
        List<SysLog> list =  sysLogService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        PageInfo<SysLog> pageInfo = new PageInfo<>(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
