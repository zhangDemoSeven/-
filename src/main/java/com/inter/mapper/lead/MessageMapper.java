package com.inter.mapper.lead;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.lead.Message;


public interface MessageMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    /** 分页数据*/
    List<Message> getLimitData(
    		@Param("messageName")String messageName,
    		@Param("startDate")Date startDate,
    		@Param("endDate")Date endDate,
    		@Param("offset")Integer offset, 
    		@Param("limit")Integer limit);

	/** 获得总数*/
	int getCount(@Param("messageName")String messageName,
    		@Param("startDate")Date startDate,
    		@Param("endDate")Date endDate);

	/** 修改状态为删除状态*/
	void updateStatusToZero(int parseInt);

	/** 查询所有的消息*/
	List<Message> getAllMessage();

}
