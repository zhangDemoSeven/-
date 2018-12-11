package com.inter.service.lead.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.dictionaries.LevelMapper;
import com.inter.mapper.lead.MessageMapper;
import com.inter.pojo.dictionaries.Level;
import com.inter.pojo.lead.Message;
import com.inter.pojo.system.User;
import com.inter.service.lead.MessageService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class MessageServiceImpl extends BaseService implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	LevelMapper levelMapper;

	@Override
	public PageHelper<Message> getList(String messageName,String queryDate,Integer offset,Integer limit) throws CustomException, ParseException {
		
		Date startDate = null;
		Date endDate = null;
		if(isNotBlank(queryDate)) {
			String[] date = queryDate.split("~");
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(date[0].trim());
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(date[1].trim());
		}
		
		List<Message> list = messageMapper.getLimitData(messageName,startDate,endDate,offset,limit);
		
		for (Message message2 : list) {
		
			List<String> levelNameList = new ArrayList<String>();	//集合保存部门名称字符串
			
			String[] targetIdArr = message2.getTarget().split(",");//切割部门的名称
			
			if(isNotExist(targetIdArr)) {
				for (String id : targetIdArr) {
					if(isNotBlank(id)) {
						Level level = levelMapper.selectByPrimaryKey(Integer.parseInt(id));
						if(isNotExist(level)) {
							levelNameList.add(level.getName());//根据部门id查询部门名称
						}
					}
				}
			}
			
			message2.setTargetName(StringUtils.join(levelNameList,","));
		}
		
		int count = messageMapper.getCount(messageName,startDate,endDate);
		
		return new PageHelper<Message>(count,list);
	}

	
	@Override
	public Map<String, Object> addEntity(Message message) throws CustomException {
		
		User user = (User) getSubject().getPrincipal();
		
		if(message == null) throw new CustomException("错误传参");

		System.err.println("目标部门");
		
		message.setCreateTime(new Date());
		message.setCreateUser(user.getNickName());
		message.setSource(user.getLevel());
		message.setStatus(STRING_NUMBER_ONE);
		
		messageMapper.insertSelective(message);
	
		return createMessageMap(2000, "发送消息成功");
	}


	@Override
	public Map<String, Object> delEntity(String ids) throws CustomException {
		
		if(isBlank(ids)) throw new CustomException("请选中一条记录操作");
		
		String[] idArr = ids.split(",");
		
		for (String id : idArr) if(id != null) messageMapper.updateStatusToZero(Integer.parseInt(id));
		
		return createMessageMap(DEL, SUCCESS);
	}


	@Override
	public List<Message> getFiveMessage(User user) throws CustomException {
		
		List<Message> allMessage = messageMapper.getAllMessage();//查询全部的消息
		
		List<Message> list  = new ArrayList<Message>();
		
		for (Message message : allMessage) {
			
			if(message.getTarget().indexOf(user.getLevel())!=-1) list.add(message); //获得包含当前登录用户部门的消息
			
			//if(list.size() == 5) break;
		}
		
		return list;
	}
}
