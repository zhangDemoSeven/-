package com.inter.controller.log;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.pojo.log.SysLog;
import com.inter.service.log.SysLogService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("/s/view.do")
	public String initLogListView() throws ReturnViewException, CustomException {
		checkPermissionToView("SYSTEM_LOGVIEW");
		return "system/log/log_list";
	}
	
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<SysLog> getLogListByPage(String methodName,String isOk,String modelName,String queryDate, Integer offset,Integer limit) throws ParseException, ReturnViewException, CustomException{
		checkPermissionToView("SYSTEM_LOGLIST");
		return sysLogService.getLogListByPage(methodName,isOk,modelName,queryDate,offset,limit);
	}
}
