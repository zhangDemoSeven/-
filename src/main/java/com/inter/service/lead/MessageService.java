package com.inter.service.lead;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.lead.Message;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;

public interface MessageService {

	/** 数据表格
	 * @throws CustomException 
	 * @throws ParseException */
	PageHelper<Message> getList(String messageName,String queryDate,Integer offset, Integer limit) throws CustomException, ParseException;
	
	/** 添加实体*/
	Map<String, Object> addEntity(Message message)  throws CustomException ;

	/** 批量删
	 * @throws CustomException */
	Map<String, Object> delEntity(String ids) throws CustomException;

	/** 获得当前用户5条消息
	 * @throws CustomException */
	List<Message> getFiveMessage(User user) throws CustomException;

}
