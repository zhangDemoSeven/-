package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Channel;
import com.inter.utils.PageHelper;
import com.inter.vo.ChannelVo;

public interface ChannelService {

	List<ChannelVo> getChannelListByNoPage() throws CustomException;

	Channel selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Channel> getChannelListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateChannel(Channel channel, Integer pid)throws CustomException;

	Map<String, Object> optChannel(Integer id)throws CustomException;

	Map<String, Object> delChannel(Integer id)throws CustomException;

	
	/**
	 * @param id 
	 * @Description:
	 * 			获得全部的父级分类实体
	 */
	List<Channel> selectParentList(Integer id);

	/** 获得当前渠道的父级对象
	 * @throws CustomException */
	Channel getParent(Integer channelId) throws CustomException;

}
