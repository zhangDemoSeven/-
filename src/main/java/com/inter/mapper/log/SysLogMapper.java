package com.inter.mapper.log;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.log.SysLog;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

	Integer getCount(@Param("methodName")String methodName,
			@Param("isOk")String isOk, 
			@Param("modelName")String modelName,
			@Param("startTime")Date startTime, 
			@Param("endTime")Date endTime);

	List<SysLog> getLogListByPage(
			@Param("methodName")String methodName,
			@Param("isOk")String isOk, 
			@Param("modelName")String modelName,
			@Param("startTime")Date startTime, 
			@Param("endTime")Date endTime,
			@Param("offset")Integer offset, 
			@Param("limit")Integer limit);
}