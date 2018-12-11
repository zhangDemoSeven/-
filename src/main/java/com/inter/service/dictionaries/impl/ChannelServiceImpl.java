package com.inter.service.dictionaries.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.dictionaries.ChannelMapper;
import com.inter.pojo.dictionaries.Channel;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.ChannelService;
import com.inter.utils.PageHelper;
import com.inter.vo.ChannelVo;

@Service
@Transactional
public class ChannelServiceImpl extends BaseService implements ChannelService {

	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public List<ChannelVo> getChannelListByNoPage() {

		List<ChannelVo> list =new ArrayList<ChannelVo>();
		
		//先查询父节点, 把父节点名称作为map集合的key 子节点集合作为map的value
		List<Channel> parentChannelList =  channelMapper.getChannelListByPidIsZero();
		for (Channel channel : parentChannelList) {
			if(channel != null) {
				//根据父节点id查询子节点集合
				Integer parentId = channel.getId();
				//子节点集合
				List<Channel> childChannelList = channelMapper.getParentChannelListByPid(parentId);
			
				ChannelVo vo = new ChannelVo();
				
				vo.setParentName(channel.getChannelName());
				
				vo.setChildChannelList(childChannelList);
				
				list.add(vo);
				
			}
		}
		
		return list;
	}

	@Override
	public Channel selectByPrimaryKey(Integer id) throws CustomException {
		return channelMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageHelper<Channel> getChannelListByPage(String name,Integer offset, Integer limit) throws CustomException {

		Integer total = channelMapper.getCount(name);
		
		List<Channel> list = channelMapper.getChannelListByPage(name,offset,limit);
		
		return new PageHelper<Channel>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateChannel(Channel channel,Integer pid) throws CustomException {

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(channel.getId())) {
			channel.setCreateTime(new Date());
			channel.setCreateUser(user.getNickName());
			channel.setModifyUser(user.getNickName());
			channel.setModifyTime(new Date());
			channel.setProhibition(STRING_NUMBER_ONE);
			channel.setStatus(STRING_NUMBER_ONE);
			if(pid != null) channel.setPid(pid);
				else channel.setPid(0);
			if(channelMapper.insertSelective(channel) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			channel.setModifyUser(user.getNickName());
			channel.setModifyTime(new Date());
			if(channel.getPid() == null) channel.setPid(0);
	
			if(channelMapper.updateByPrimaryKeySelective(channel) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Map<String, Object> optChannel(Integer id) throws CustomException {

		if(isBlank(id)) throw new CustomException("传参异常");
		
		Channel channel = channelMapper.selectByPrimaryKey(id);
		
		if(isExist(channel)) throw new CustomException("查询异常");
		
		String prohibition = channel.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) channel.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) channel.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		channel.setModifyTime(new Date());
		channel.setModifyUser(user.getNickName());
		
		if(channelMapper.updateByPrimaryKeySelective(channel) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
	}

	@Override
	public Map<String, Object> delChannel(Integer id) throws CustomException {

		if(isBlank(id)) throw new CustomException("传参异常");
		
		Channel channel = channelMapper.selectByPrimaryKey(id);
		
		if(isExist(channel)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		channel.setStatus(STRING_NUMBER_ZERO);
		channel.setProhibition(STRING_NUMBER_ZERO);
		channel.setModifyTime(new Date());
		channel.setModifyUser(user.getNickName());
		
		if(channelMapper.updateByPrimaryKeySelective(channel) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
	}

	@Override
	public List<Channel> selectParentList(Integer cId) {
		return channelMapper.selectParentLsit(cId);
	}

	@Override
	public Channel getParent(Integer channelId) throws CustomException {
		
		if(channelId == null) throw new CustomException("回显父级失败");
		
		return channelMapper.selectParentById(channelId);
	}
}
