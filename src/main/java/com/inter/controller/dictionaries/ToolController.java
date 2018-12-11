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
import com.inter.pojo.dictionaries.Tool;
import com.inter.service.dictionaries.ToolService;
import com.inter.utils.PageHelper;

/**咨询工具*/
@Controller
@RequestMapping("/tool")
public class ToolController extends BaseController {

	@Autowired
	private ToolService toolService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Tool> getToolListByNoPage(){
		return toolService.getToolListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="咨询工具字典管理",operationSource="教师端")
	public String initToolView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_TOOL");
		return "dictionaries/tool_list";
	}
	
	@RequestMapping("/show/tool.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("tool", toolService.selectByPrimaryKey(id));
		}
		return "dictionaries/tool_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Tool> getToolListByPage(String name,Integer offset,Integer limit) throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_TOOL");
		return toolService.getToolListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/tool.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增咨询工具",operationSource="教师端")
	public Map<String,Object> saveOrUpdateTool(Tool tool) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_TOOL");
		return toolService.saveOrUpdateTool(tool);
	}
	
	@RequestMapping("/opt/tool.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁咨询工具",operationSource="教师端")
	public Map<String,Object> optTool(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_TOOL");
		return toolService.optTool(id);
	}
	
	@RequestMapping("/del/tool.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除咨询工具",operationSource="教师端")
	public Map<String,Object> delTool(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_TOOL");
		return toolService.delTool(id);
	}
	
}
