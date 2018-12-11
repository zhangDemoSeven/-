package com.inter.controller.dictionaries;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.annotation.Log;
import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.pojo.dictionaries.Channel;
import com.inter.service.dictionaries.ChannelService;
import com.inter.utils.PageHelper;
import com.inter.vo.ChannelVo;

@Controller
@RequestMapping("/channel")
public class ChannelController extends BaseController {

	@Autowired
	private ChannelService channelService;
	
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	 public List<ChannelVo> getChannelListByNoPage()throws CustomException{
		return channelService.getChannelListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="渠道字典管理页面",operationSource="教师端")
	public String initChannelView()throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHANNEL");
		return "dictionaries/channel_list";
	}
	
	@RequestMapping("/show/channel.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) model.addAttribute("channel", channelService.selectByPrimaryKey(id));
		else id = 0;
		//获得父级项
		model.addAttribute("parents", channelService.selectParentList(id));
		return "dictionaries/channel_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Channel> getChannelListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHANNEL");
		return channelService.getChannelListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/channel.do")
	@ResponseBody
	@Log(operationName="保存或修改渠道",operationSource="教师端",operationType="渠道字典")
	public Map<String,Object> saveOrUpdateChannel(Channel channel,Integer pid) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHANNEL");
		return channelService.saveOrUpdateChannel(channel,pid);
	}
	
	@RequestMapping("/opt/channel.do")
	@ResponseBody
	@Log(operationName="启禁渠道",operationSource="教师端",operationType="渠道字典")
	public Map<String,Object> optChannel(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHANNEL");
		return channelService.optChannel(id);
	}
	
	@RequestMapping("/del/channel.do")
	@ResponseBody
	@Log(operationName="删除渠道",operationSource="教师端",operationType="渠道字典")
	public Map<String,Object> delChannel(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHANNEL");
		return channelService.delChannel(id);
	}
	
	@RequestMapping("/back/parent.do")
	@ResponseBody
	public Channel getChannelParent(Integer channelId) throws CustomException {
		//返回父级对象
		return channelService.getParent(channelId);
	}
	
}
