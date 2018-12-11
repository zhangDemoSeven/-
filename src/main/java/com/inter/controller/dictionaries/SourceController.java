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
import com.inter.pojo.dictionaries.Source;
import com.inter.service.dictionaries.SourceService;
import com.inter.utils.PageHelper;
import com.inter.vo.SourceVo;

/**
 * 
* @ClassName: SourceController 
* @Description: 网站来源
* @author 石家庄北大青鸟Y2教员 韩志彬
* @date 2018年11月15日 上午11:26:35
 */
@Controller
@RequestMapping("/source")
public class SourceController extends BaseController {

	
	@Autowired
	private SourceService sourceService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<SourceVo> getSourceListByNoPage()throws CustomException{
		return sourceService.getSourceListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="来源字典管理",operationSource="教师端")
	public String initSourceView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_SOURCE");
		return "dictionaries/source_list";
	}
	
	@RequestMapping("/show/source.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null)model.addAttribute("source", sourceService.selectByPrimaryKey(id));
		else id = 0;
		//获得父级项
		model.addAttribute("parents", sourceService.selectParentList(id));
		return "dictionaries/source_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Source> getSourceListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_SOURCE");
		return sourceService.getSourceListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/source.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增来源",operationSource="教师端")
	public Map<String,Object> saveOrUpdateSource(Source source,Integer pid) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_SOURCE");
		return sourceService.saveOrUpdateSource(source,pid);
	}
	
	@RequestMapping("/opt/source.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁来源字典",operationSource="教师端")
	public Map<String,Object> optSource(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_SOURCE");
		return sourceService.optSource(id);
	}
	
	@RequestMapping("/del/source.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除来源",operationSource="教师端")
	public Map<String,Object> delSource(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_SOURCE");
		return sourceService.delSource(id);
	}
	
	
	@RequestMapping("/back/parent.do")
	@ResponseBody
	public Source getChannelParent(Integer channelId) throws CustomException {
		//返回父级对象
		return sourceService.getParent(channelId);
	}
	
}
