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
import com.inter.pojo.system.Role;
import com.inter.pojo.system.User;
import com.inter.service.system.RoleService;
import com.inter.utils.PageHelper;


@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{

	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="系统管理",operationName="角色管理页面",operationSource="教师端")
	public String showRoleListView() throws ReturnViewException, CustomException {
		checkPermissionToView("ROLE_VIEW");
		return "system/role/role_list";
	}
	
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Role> getRoleListByPage(String roleName,Integer offset,Integer limit)throws CustomException{
		checkPermissionToMessage("ROLE_LIST");
		return roleService.getRoleListByPage(roleName,offset,limit);
	}
	
	
	@RequestMapping("/show/addentity.do")
	public String showAddRoleView(Model model ,Integer roleId)throws CustomException, ReturnViewException {
		if(roleId != null) {
			checkPermissionToView("ROLE_EDIT");
			Role role = roleService.selectByPrimaryKey(roleId);
			model.addAttribute("role", role);
		}
		
		checkPermissionToView("ROLE_SAVE");
		return "system/role/role_add";
	}
	
	@RequestMapping("/check/name.do")
	@ResponseBody
	public Map<String,Object> checkName(String name)throws CustomException{
		return roleService.checkName(name);
	}
	
	
	@RequestMapping("/add/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="新增角色",operationSource="教师端")
	public Map<String,Object> saveOrUpdateRole(String []permissionIds,String[]menuIds,Role role)throws CustomException{
		if(role.getId() == null) {
			checkPermissionToMessage("ROLE_SAVE");
		}else {
			checkPermissionToMessage("ROLE_EDIT");
		}
		
		return roleService.saveOrUpdateRole(permissionIds,menuIds,role);
	}
	
	@RequestMapping("/opt/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="启禁角色",operationSource="教师端")
	public Map<String,Object> optRole(Integer roleId)throws CustomException{
		checkPermissionToMessage("ROLE_OPT");
		return roleService.optRole(roleId);
	}
	

	@RequestMapping("/del/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="删除角色",operationSource="教师端")
	public Map<String,Object> delRole(Integer roleId)throws CustomException{
		checkPermissionToMessage("ROLE_DEL");
		return roleService.delRole(roleId);
	}
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Role> getRoleListNoPage()throws CustomException{
		return roleService.getRoleListNoPage();
	}
	
	@RequestMapping("/back/entity.do")
	@ResponseBody
	public List<Role> getRoleListByUserId(Integer userId)throws CustomException{
		return roleService.findRoleByUser(new User(userId));
	}
}
