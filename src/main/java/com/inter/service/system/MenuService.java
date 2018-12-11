package com.inter.service.system;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.system.Menu;
import com.inter.utils.PageHelper;
import com.inter.vo.MenuVo;

public interface MenuService {

	List<MenuVo> getMenuListByUser() throws CustomException;

	PageHelper<Menu> getMenuListByPage(String menuName,Integer offset,Integer limit) throws CustomException;

	Menu selectByPrimaryKey(Integer menuId) throws CustomException;

	List<Map<String, Object>> showMenuNameList() throws CustomException;

	Map<String, Object> saveOrUpdateMenu(Menu menu) throws CustomException;

	Map<String, Object> optMenu(Integer menuId) throws CustomException;

	Map<String, Object> delMenu(Integer menuId) throws CustomException;

	List<Menu> loadMenu( ) throws CustomException;

	List<Menu> getMenuListByRoleId(Integer roleId) throws CustomException;

}
