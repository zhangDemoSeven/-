package com.inter.controller.lead;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.pojo.lead.Message;
import com.inter.pojo.system.User;
import com.inter.service.lead.MessageService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController{
	
	@Autowired
	MessageService messageService;

	/** 消息管理页面*/
	@RequestMapping("/s/view.do")
	public String getView() {
		return "message/message_list";
	}
	
	
	/** 新增消息页面
	 * @throws CustomException 
	 * @throws ReturnViewException */
	@RequestMapping("/addentity/view.do")
	public String addEntityView() throws ReturnViewException, CustomException {
		checkPermissionToView("MESSAGE_SAVE");
		return "message/message_add";
	}
	
	@RequestMapping("/s/list.do")
	@ResponseBody
	public PageHelper<Message> getList(String messageName,String queryDate,Integer offset,Integer limit) throws CustomException, Exception{
		checkPermissionToMessage("MESSAGE_LIST");
		return messageService.getList(messageName,queryDate,offset,limit);
	}
	
	
	@RequestMapping("/add/entity.do")
	@ResponseBody
	public Map<String,Object> addEntity(Message message) throws CustomException{
		checkPermissionToMessage("MESSAGE_SAVE");
		return messageService.addEntity(message);
	}
	
	
	@RequestMapping("/del/entity.do")
	@ResponseBody
	public Map<String, Object> delEntity(String ids) throws CustomException{
		checkPermissionToMessage("MESSAGE_DEL");
		return messageService.delEntity(ids);
	}

	@RequestMapping("/get/entity.do")
	@ResponseBody
	public List<Message> getFiveMessage() throws CustomException{
		User user = BaseController.getCurrentUser();
		return messageService.getFiveMessage(user);
	}
}