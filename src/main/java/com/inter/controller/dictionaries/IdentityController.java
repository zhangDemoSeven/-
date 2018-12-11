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
import com.inter.pojo.dictionaries.Identity;
import com.inter.service.dictionaries.IdentityService;
import com.inter.utils.PageHelper;

/**身份*/
@Controller
@RequestMapping("/identity")
public class IdentityController extends BaseController {

	@Autowired
	private IdentityService identityService;
	
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Identity> getIdentityListNoPage()throws CustomException{
		return identityService.getIdentityListNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="身份字典管理页面",operationSource="教师端")
	public String showIdentityListView() throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_IDENTITY");
		return "dictionaries/identity_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Identity> getListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_IDENTITY");
		return identityService.getListByPage(name,offset,limit);
	}
	
	@RequestMapping("/show/identity.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("identity", identityService.selectByPrimaryKey(id));
		}
		return "dictionaries/identity_add";
	}
	
	@RequestMapping("/add/identity.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增身份字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateIdentity(Identity identity) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_IDENTITY");
		return identityService.saveOrUpdateIdentity(identity);
	}
	
	@RequestMapping("/opt/identity.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁身份字典",operationSource="教师端")
	public Map<String,Object> optIdentity(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_IDENTITY");
		return identityService.optIdentity(id);
	}
	
	@RequestMapping("/del/identity.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除身份字典",operationSource="教师端")
	public Map<String,Object> delIdentity(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_IDENTITY");
		return identityService.delIdentity(id);
	}
	
}