package com.inter.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.system.MenuMapper;
import com.inter.mapper.system.PermissionMapper;
import com.inter.mapper.system.RoleAndMenuMapper;
import com.inter.mapper.system.RoleAndPermissionMapper;
import com.inter.mapper.system.RoleMapper;
import com.inter.pojo.system.Menu;
import com.inter.pojo.system.Permission;
import com.inter.pojo.system.Role;
import com.inter.pojo.system.RoleAndMenuKey;
import com.inter.pojo.system.RoleAndPermissionKey;
import com.inter.pojo.system.User;
import com.inter.service.system.RoleService;
import com.inter.utils.PageHelper;


@Service
@Transactional
public class RoleServiceImpl extends BaseService implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private RoleAndPermissionMapper roleAndPermissionMapper;
	
	@Autowired
	private RoleAndMenuMapper roleAndMenuMapper;
	
	
	@Override
	public List<Role> findRoleByUser(User user) {

		if("admin".equals(user.getUsername())) {
			return roleMapper.findAllRoleList();
		}else {
			return roleMapper.findRoleListByUserId(user.getId());
		}
	}
	
	@Override
	public PageHelper<Role> getRoleListByPage(String roleName,Integer offset,Integer limit)throws CustomException {
		PageHelper<Role> pageHelper = new PageHelper<Role>();
		Integer total = roleMapper.getCountByPage(roleName);
		List<Role> list = roleMapper.getRoleListByPage(roleName,offset,limit);
		pageHelper.setRows(list);
		pageHelper.setTotal(total);
		return pageHelper;
	}

	@Override
	public Role selectByPrimaryKey(Integer roleId) throws CustomException{
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public Map<String, Object> saveOrUpdateRole(String[] permissionIds, String[] menuIds, Role role) throws CustomException{
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if(role.getId() == null) {
			
			role.setCreateTime(new Date());
			role.setMdifyTime(new Date());
			role.setCreateUser(user.getNickName());
			role.setModifyUser(user.getNickName());
			role.setStatus(STRING_NUMBER_ONE);
			role.setProhibition(STRING_NUMBER_ONE);

			roleMapper.insertBackPrimaryKey(role);//插入角色数据到角色表中

			Integer roleId = role.getId();// 主键返回
			
			for(String idStr:permissionIds) {
				
				Integer permissionId = Integer.parseInt(idStr);

				//保存权限ID和角色ID到中间表
				RoleAndPermissionKey key = new RoleAndPermissionKey();

				key.setPermissionId(permissionId);
				
				key.setRoleId(roleId);

				roleAndPermissionMapper.insert(key);
			}
			
			for (String idStr : menuIds) {
				Integer menuId = Integer.parseInt(idStr);
				RoleAndMenuKey key = new RoleAndMenuKey();
				//保存子节点
				key.setMenuId(menuId);
				key.setRoleId(roleId);
				roleAndMenuMapper.insert(key);
				
				//通过子节点ID查询父节点
				Menu parentMenu = menuMapper.getParentMenuByChildrenId(menuId);
				
				//查询中间表role_menu 是否有该条绑定记录
				RoleAndMenuKey roleAndMenu = roleAndMenuMapper.getRoleAndMenuByMenuIdAndRoleId(parentMenu.getId(),roleId);
			
				if(roleAndMenu != null) {
					//说明在中间表已经存在该子节点的父节点
					continue;
				}else {
					//说明添加的子节点的父节点在中间表中不存在,所以让其父节点ID和roleID进行关联
					key.setMenuId(parentMenu.getId());
					key.setRoleId(roleId);
					roleAndMenuMapper.insert(key);
				}
			}
			
		}else if(role.getId() != null){
			
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			//删除原来的菜单和权限  与现在传递的ID无关
			//先查询原来的子节点菜单集合
			List<Menu> menuList = menuMapper.getMenuListByRoleId(role.getId());
			if(menuList != null) {
				for (Menu menu : menuList) {
					//通过子节点ID查询父节点
					Menu parentMenu = menuMapper.getParentMenuByChildrenId(menu.getId());
					//查询中间表role_menu 是否有该条绑定记录
					RoleAndMenuKey roleAndMenu = roleAndMenuMapper.getRoleAndMenuByMenuIdAndRoleId(parentMenu.getId(),role.getId());
					//删除父节点与角色绑定的记录
					if(roleAndMenu != null && parentMenu != null) {
						roleAndMenuMapper.deleteRoleAndMenuByRoleIdAndMenuId(role.getId(), parentMenu.getId());
					}
					//删除中间表  只要删除中间表 即删除了角色与菜单的关联,不能删除菜单,否则表数据将被删除
					roleAndMenuMapper.deleteRoleAndMenuByRoleIdAndMenuId(role.getId(),menu.getId());
				}
			}
			
			List<Permission> permissionList = permissionMapper.getPermissionListByRoleId(role.getId());
			if(permissionList != null) {
				for (Permission permission : permissionList) {
					if(permission != null) {
						roleAndPermissionMapper.deleteRoleAndPermissionByRoleIdAndPermissionId(role.getId(),permission.getId());
					}
				}
			}
			
			//添加中间表
			for(String permissionIdStr: permissionIds) {
				Integer permissionId = Integer.parseInt(permissionIdStr);
				RoleAndPermissionKey key = new RoleAndPermissionKey();
				key.setRoleId(role.getId());
				key.setPermissionId(permissionId);
				roleAndPermissionMapper.insert(key);
			}
			
			for (String menuIdStr : menuIds) {
				Integer menuId = Integer.parseInt(menuIdStr);
				RoleAndMenuKey key = new RoleAndMenuKey();
				key.setMenuId(menuId);
				key.setRoleId(role.getId());
				roleAndMenuMapper.insert(key );
				
				//通过子节点ID查询父节点
				Menu parentMenu = menuMapper.getParentMenuByChildrenId(menuId);
				
				//查询中间表role_menu 是否有该条绑定记录
				RoleAndMenuKey roleAndMenu = roleAndMenuMapper.getRoleAndMenuByMenuIdAndRoleId(parentMenu.getId(),role.getId());
				
				if(roleAndMenu != null) {
					//说明在中间表已经存在该子节点的父节点
					continue;
				}else {
					//说明添加的子节点的父节点在中间表中不存在,所以让其父节点ID和roleID进行关联
					key.setMenuId(parentMenu.getId());
					key.setRoleId(role.getId());
					roleAndMenuMapper.insert(key);
				}
				
				roleMapper.updateByPrimaryKeySelective(role);
			}
		}
		
		return createMessageMap(SAVE, SUCCESS);
	}
	
	@Override
	public Map<String, Object> optRole(Integer roleId)throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		Role role = roleMapper.selectByPrimaryKey(roleId);
		
		if(role != null) {
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			if(role.getProhibition().equals(STRING_NUMBER_ONE)) {
				role.setProhibition(STRING_NUMBER_ZERO);
			}else if(role.getProhibition().equals(STRING_NUMBER_ZERO)){
				role.setProhibition(STRING_NUMBER_ONE);
			}
			
			if(roleMapper.updateByPrimaryKeySelective(role) == INTEGER_NUMBER_ONE) {
				return createMessageMap(EDIT, SUCCESS);
			}else {
				return createMessageMap(EDIT, ERROR);
			}
		}
		throw new CustomException("未知");
	}

	@Override
	public Map<String, Object> delRole(Integer roleId)throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		Role role = roleMapper.selectByPrimaryKey(roleId);
		
		if(role != null) {
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			role.setStatus(STRING_NUMBER_ZERO);
			role.setProhibition(STRING_NUMBER_ZERO);
			if(roleMapper.updateByPrimaryKeySelective(role) == INTEGER_NUMBER_ONE) {
				return createMessageMap(DEL, SUCCESS);
			}else {
				return createMessageMap(DEL, ERROR);
			}
		}
		throw new CustomException("未知");
	}

	@Override
	public List<Role> getRoleListNoPage() throws CustomException{
		return roleMapper.getRoleListNoPage();
	}

	@Override
	public Map<String, Object> checkName(String name)throws CustomException {
		
		if(isBlank(name)) throw new CustomException("未知");
		
		List<Role> roleList = roleMapper.checkName(name);
		
		if(isNotExist(roleList) && roleList.size() > 1) return createMessageMap(5000, "角色名称已经存在,请重新填写");
		
		return createCodeMap(2000);
	}
	
}
