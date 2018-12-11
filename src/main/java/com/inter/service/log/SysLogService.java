package com.inter.service.log;

import java.text.ParseException;

import com.inter.pojo.log.SysLog;
import com.inter.utils.PageHelper;

public interface SysLogService {

	PageHelper<SysLog> getLogListByPage(String methodName,String isOk,String modelName,String queryDate, Integer offset, Integer limit) throws ParseException;

}
