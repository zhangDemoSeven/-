package com.inter.controller.system;

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
import com.inter.pojo.system.Permission;
import com.inter.service.system.PermissionService;
import com.inter.utils.PageHelper;


@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController{

	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="系统管理",operationName="权限管理页面",operationSource="教师端")
	public String initPermissionListView() throws ReturnViewException, CustomException {
		checkPermissionToView("PERMISSION_VIEW");
		return "system/perm/permission_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Permission> getPermissionByPage(String permissionName,Integer offset,Integer limit)throws CustomException{
		checkPermissionToMessage("PERMISSION_LIST");
		return  permissionService.getPermissionByPage(permissionName,offset,limit);
	}
	
	@RequestMapping("/show/addentity.do")
	public String initAddOrUpdateView(Model model,Integer permissionId) throws CustomException, ReturnViewException{
		if(permissionId != null) {
			checkPermissionToView("PERMISSION_EDIT");
			Permission permission = permissionService.selectByPrimaryKey(permissionId);
			model.addAttribute("permission",permission);
		}
		checkPermissionToView("PERMISSION_SAVE");
		return "system/perm/permission_add";
	}
	
	@RequestMapping("/check/name.do")
	@ResponseBody
	public Map<String,Object> checkName(String name)throws CustomException{
		return permissionService.checkName(name);
	}
	
	@RequestMapping("/add/entity.do")
	@ResponseBody
	public Map<String,Object> saveOrUpdatePermission(Permission permission)throws CustomException{
		
		if(permission.getId() == null) {
			checkPermissionToMessage("PERMISSION_SAVE");
		}else {
			checkPermissionToMessage("PERMISSION_EDIT");
		}
		return permissionService.saveOrUpdatePermission(permission);
	}
	
	@RequestMapping("/opt/entity.do")
	@ResponseBody
	@Log(operationName="启禁权限信息",operationSource="教师端",operationType="权限管理")
	public Map<String,Object> optPermission(Integer permissionId)throws CustomException{
		checkPermissionToMessage("PERMISSION_OPT");
		return permissionService.optPermission(permissionId);
	}
	
	@RequestMapping("/del/entity.do")
	@ResponseBody
	@Log(operationName="逻辑删除权限信息",operationSource="教师端",operationType="权限管理")
	public Map<String, Object> delPermissionById(Integer permissionId)throws CustomException {
		checkPermissionToMessage("PERMISSION_DEL");
		return permissionService.delPermissionById(permissionId);
	}
	
	@RequestMapping("/get/load.do")
	@ResponseBody
	public List<Permission> loadPermission()throws CustomException{
		return permissionService.loadPermission();
	}
	
	@RequestMapping("/back/entity.do")
	@ResponseBody
	public List<Permission> getPermissionListByRoleId(Integer roleId)throws CustomException{
		return permissionService.getPermissionListByRoleId(roleId); 
	}
}
