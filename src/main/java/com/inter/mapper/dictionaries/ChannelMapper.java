package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

	List<Channel> getParentChannelListByPid(Integer parentId);

	List<Channel> getChannelListByPidIsZero();

	Integer getCount(@Param("name")String name);

	List<Channel> getChannelListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);

	/**
	 * @Description:
	 * 			获得全部的父级项
	 * @author 盼盼
	 * @param cId 
	 */
	List<Channel> selectParentLsit(Integer cId);

	/**
	 * @Description:
	 * 			根据渠道ID 查询父级ID
	 * @param channelId
	 * 			当前的ChanneliD
	 */
	Channel selectParentById(Integer channelId);
}