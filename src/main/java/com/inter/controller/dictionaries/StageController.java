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
import com.inter.pojo.dictionaries.Stage;
import com.inter.service.dictionaries.StageService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/stage")
public class StageController extends BaseController{

	@Autowired
	private StageService stageService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Stage> getStageListByNoPage()throws CustomException{
		return stageService.getStageListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="阶段字典管理页面",operationSource="教师端")
	public String initStageListView() throws ReturnViewException, CustomException {
		checkPermissionToView("DICTIONARIES_STAGE");
return "dictionaries/stage_list";
	}
	
	@RequestMapping("/show/stage.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("stage", stageService.selectByPrimaryKey(id));
		}
		return "dictionaries/stage_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Stage> getStageListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException {
		checkPermissionToView("DICTIONARIES_STAGE");
return stageService.getStageListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/stage.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增阶段",operationSource="教师端")
	public Map<String,Object> saveOrUpdatestage(Stage stage) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STAGE");
return stageService.saveOrUpdateStage(stage);
	}
	
	@RequestMapping("/opt/stage.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁阶段",operationSource="教师端")
	public Map<String,Object> optStage(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STAGE");
return stageService.optStage(id);
	}
	
	@RequestMapping("/del/stage.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除阶段",operationSource="教师端")
	public Map<String,Object> delStage(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STAGE");
return stageService.delStage(id);
	}
	
	
	/**
	 * @throws CustomException 
	 * @Title: getAllStages
	 * @Description: TODO
	 * @param @return    参数
	 * @return Object    返回类型
	 * @throws
	 */
	@RequestMapping("/getAllStages.do")
	@ResponseBody
	public Object getAllStages() throws CustomException {
		return stageService.getAllStages();
	}
}
