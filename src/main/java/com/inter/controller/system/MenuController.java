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
import com.inter.pojo.system.Menu;
import com.inter.service.system.MenuService;
import com.inter.utils.PageHelper;
import com.inter.vo.MenuVo;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/show.do")
	@ResponseBody
	public List<MenuVo> initMenuListView() throws CustomException {
		return menuService.getMenuListByUser();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="系统管理",operationName="菜单管理页面",operationSource="教师端")
	public String showMenuListView() throws ReturnViewException, CustomException {
		checkPermissionToView("MENU_VIEW");
		return "system/menu/menu_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Menu> getMenuListByPage(String menuName,Integer offset,Integer limit)throws CustomException{
		checkPermissionToMessage("MENU_LIST");
		return menuService.getMenuListByPage(menuName,offset,limit);
	}
	
	@RequestMapping("/show/addentity.do")
	@Log(operationSource="教师端",operationName="保存或修改菜单",operationType="菜单管理")
	public String showAddOrUpdateMenuView(Model model,Integer menuId) throws CustomException, ReturnViewException{
		if(menuId != null) {
			checkPermissionToView("MENU_EDIT");
			Menu menu = menuService.selectByPrimaryKey(menuId);
			model.addAttribute("menu", menu);
		}
		checkPermissionToView("MENU_SAVE");
		return "system/menu/menu_add";
	}
	
	
	@RequestMapping("/get/select.do")
	@ResponseBody
	public List<Map<String,Object>> showMenuNameList()throws CustomException{
		return menuService.showMenuNameList();
	}
	
	
	
	
	@RequestMapping("/add/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="新增菜单",operationSource="教师端")
	public Map<String,Object> saveOrUpdateMenu(Menu menu)throws CustomException{
		if(menu.getId() == null) {
			checkPermissionToMessage("MENU_SAVE");
		}else {
			checkPermissionToMessage("MENU_EDIT");
		}
		
		return menuService.saveOrUpdateMenu(menu);
	}
	
	
	@RequestMapping("/opt/entity.do")
	@ResponseBody
	@Log(operationSource="教师端",operationName="启禁菜单",operationType="菜单管理")
	public Map<String,Object> optMenu(Integer menuId)throws CustomException{
		checkPermissionToMessage("MENU_OPT");
		return menuService.optMenu(menuId);
	}
	
	
	@RequestMapping("/del/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="删除菜单",operationSource="教师端")
	public Map<String,Object> delMenu(Integer menuId)throws CustomException{
		checkPermissionToMessage("MENU_DEL");
		return menuService.delMenu(menuId);
	}
	
	
	@RequestMapping("/get/load.do")
	@ResponseBody
	public List<Menu> loadMenu()throws CustomException{
		return menuService.loadMenu();
	}
	
	
	@RequestMapping("/back/entity.do")
	@ResponseBody
	public List<Menu> getMenuListByRoleId(Integer roleId)throws CustomException{
		return menuService.getMenuListByRoleId(roleId); 
	}
}