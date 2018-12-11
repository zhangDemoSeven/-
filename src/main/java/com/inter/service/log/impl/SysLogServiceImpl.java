package com.inter.service.log.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.mapper.log.SysLogMapper;
import com.inter.pojo.log.SysLog;
import com.inter.service.log.SysLogService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class SysLogServiceImpl extends BaseService implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;


	@Override
	public PageHelper<SysLog> getLogListByPage(String methodName, String isOk, String modelName, String queryDate,
			Integer offset, Integer limit) throws ParseException {
		
		Date startTime = null;
		Date endTime = null;
		
		if(isNotBlank(queryDate)) {
			String[] dateArray = queryDate.split("~");
			startTime = new SimpleDateFormat("yyyy-MM-dd").parse(dateArray[0]);
			endTime = new SimpleDateFormat("yyyy-MM-dd").parse(dateArray[1]);
		}
		
		Integer total = sysLogMapper.getCount(methodName,isOk,modelName,startTime,endTime);
		
		List<SysLog> list = sysLogMapper.getLogListByPage(methodName,isOk,modelName,startTime,endTime, offset, limit);
		
		return new PageHelper<SysLog>(total,list);
	}
}
