package com.java.service.systemLog;

import com.java.domain.SysLog;

import java.util.List;

/**
 * 日志
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page, Integer size) throws Exception;
}
