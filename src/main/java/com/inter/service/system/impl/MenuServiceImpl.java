package com.inter.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.system.MenuMapper;
import com.inter.pojo.system.Menu;
import com.inter.pojo.system.User;
import com.inter.service.system.MenuService;
import com.inter.utils.PageHelper;
import com.inter.vo.MenuVo;

@Service
@Transactional
public class MenuServiceImpl extends BaseService implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<MenuVo> getMenuListByUser() throws CustomException {
		// 获得当前登录的用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();

		List<MenuVo> list = new ArrayList<MenuVo>();// 反参集合

		if ("admin".equals(user.getUsername())) {
			List<Menu> parentMenus = menuMapper.getParentMenuListByPidIsNull();
			for (Menu menu : parentMenus) {
				Set<Menu> childSet = menuMapper.getChildrenMenuListByPid(menu.getId());
				Set<MenuVo> childMenuVo = new HashSet<MenuVo>();
				for (Menu menuChild : childSet) {
					childMenuVo.add(new MenuVo(menuChild.getTitle(),"",menuChild.getHref(), false));
				}
				MenuVo mv = new MenuVo(menu.getTitle(),"","", false, childMenuVo);
				list.add(mv);
			}
		} else {
			List<Menu> menuList = menuMapper.getMenuListByUserId(user.getId());
			for (Menu menu : menuList) {
				if (menu.getPid() == null) {
					Set<Menu> childMenuSet = menuMapper.getAllChildrenMenuListByPid(menu.getId(), user.getId());
					Set<MenuVo> childMenuVo = new HashSet<MenuVo>();
					for (Menu menuChild : childMenuSet) {
						childMenuVo.add(new MenuVo(menuChild.getTitle(),"",menuChild.getHref(), false));
					}
					MenuVo mv = new MenuVo(menu.getTitle(),"","", false, childMenuVo);
					list.add(mv);
				}
			}
		}
		return list;
	}

	@Override
	public Menu selectByPrimaryKey(Integer menuId) throws CustomException{
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public PageHelper<Menu> getMenuListByPage(String menuName,Integer offset,Integer limit) throws CustomException{
		
		PageHelper<Menu> pageHelper = new PageHelper<Menu>();
		// 统计总记录数
		Integer total = menuMapper.getCount(menuName);
		pageHelper.setTotal(total);

		// 查询当前页实体对象
		List<Menu> list = menuMapper.getMenuListByPage(menuName,offset,limit);
		pageHelper.setRows(list);

		return pageHelper;
	}

	@Override
	public List<Map<String, Object>> showMenuNameList() throws CustomException{
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Menu> menuList = menuMapper.getParentMenuListByPidIsNull();
		for (Menu menu : menuList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getId());
			map.put("text", menu.getTitle());
			list.add(map);
		}
		return list;
	}

	@Override
	public List<Menu> getMenuListByRoleId(Integer roleId) throws CustomException{
		return menuMapper.getMenuListByRoleId(roleId);
	}

	@Override
	public Map<String, Object> saveOrUpdateMenu(Menu menu) throws CustomException{

		
		User user = (User) SecurityUtils.getSubject().getPrincipal();

		if (menu.getId() == null) {
			menu.setCreateTime(new Date());
			menu.setCreateUser(user.getNickName());
			menu.setMdifyTime(new Date());
			menu.setModifyUser(user.getNickName());
			menu.setProhibition(STRING_NUMBER_ONE);
			menu.setStatus(STRING_NUMBER_ONE);

			if (menuMapper.insertSelective(menu) == INTEGER_NUMBER_ONE) {
				return createMessageMap(SAVE, SUCCESS);
			}	
			else {
				return createMessageMap(SAVE, ERROR);
			}
		} else {
			Menu currentMenu = menuMapper.selectByPrimaryKey(menu.getId());
			if(currentMenu.getProhibition().equals(STRING_NUMBER_ZERO)) {
				throw new CustomException("无法编辑禁用状态下的数据");
			}
			menu.setMdifyTime(new Date());
			menu.setModifyUser(user.getNickName());
			if(menuMapper.updateByPrimaryKeySelective(menu) == INTEGER_NUMBER_ONE) {
				return createMessageMap(EDIT, SUCCESS);
			}else {
				return createMessageMap(EDIT, ERROR);
			}
		}
	}

	@Override
	public Map<String, Object> optMenu(Integer menuId) throws CustomException{

		//获得当前登录的用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(menuId == null) throw new CustomException("未知");
		
		Menu menu = menuMapper.selectByPrimaryKey(menuId);
		
		if(menu == null) throw new CustomException("未知");
		
		//如果是父级菜单,那么不能禁用
		if(menu.getPid() == null) throw new CustomException("父级菜单不可以禁用");
		
		//如果是子级菜单,可以直接修改
		String prohibition = menu.getProhibition();

		if(prohibition.equals(STRING_NUMBER_ONE)) menu.setProhibition(STRING_NUMBER_ZERO); 
		
		if(prohibition.equals(STRING_NUMBER_ZERO)) menu.setProhibition(STRING_NUMBER_ONE); 
		
		menu.setMdifyTime(new Date());
		
		menu.setModifyUser(user.getNickName());
		
		if(menuMapper.updateByPrimaryKeySelective(menu) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else  return createMessageMap(EDIT, ERROR);
	}
	
	@Override
	public Map<String, Object> delMenu(Integer menuId) throws CustomException{
		
		User user = (User) getSubject().getPrincipal();
		
		if(menuId == null) throw new CustomException("未知");
		
		Menu menu = menuMapper.selectByPrimaryKey(menuId);
		
		if(menu == null) throw new CustomException("未知");
		
		if(menu.getPid() == null) throw new CustomException("存在父级菜单,不可以删除");
		
		menu.setStatus(STRING_NUMBER_ZERO);
		menu.setProhibition(STRING_NUMBER_ZERO);
		menu.setMdifyTime(new Date());
		menu.setModifyUser(user.getNickName());
		
		if(menuMapper.updateByPrimaryKeySelective(menu) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else  return createMessageMap(DEL, ERROR);
	}

	@Override
	public List<Menu> loadMenu() throws CustomException{
		return menuMapper.loadMenu();
	}
}
