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
import com.inter.mapper.system.PermissionMapper;
import com.inter.pojo.system.Permission;
import com.inter.pojo.system.User;
import com.inter.service.system.PermissionService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class PermissionServiceImpl extends BaseService implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> findPermissionByUser(User user){
		if("admin".equals(user.getUsername())) {
			return permissionMapper.findAllPermissionList();
		}else {
			return permissionMapper.findPermissionListByUserId(user.getId());
		}
	}
	
	
	@Override
	public PageHelper<Permission> getPermissionByPage(String permissionName,Integer offset, Integer limit) throws CustomException{
		
		PageHelper<Permission> pageHelper = new PageHelper<Permission>();
		
		List<Permission> permissions = permissionMapper.getPermissionByPage(permissionName,offset,limit);
		
		Integer total = permissionMapper.getCount(permissionName);
		
		pageHelper.setRows(permissions);
		pageHelper.setTotal(total);
		
		return pageHelper;
	}

	@Override
	public Permission selectByPrimaryKey(Integer permissionId) throws CustomException{
		return permissionMapper.selectByPrimaryKey(permissionId);
	}

	@Override
	public Map<String, Object> saveOrUpdatePermission(Permission permission) throws CustomException {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		if(permission.getId() == null) {
			permission.setCreateTime(new Date());
			permission.setCreateUser(user.getNickName());
			permission.setMdifyTime(new Date());
			permission.setModifyUser(user.getNickName());
			permission.setProhibition(STRING_NUMBER_ONE);
			permission.setStatus(STRING_NUMBER_ONE);
			if(permissionMapper.insertSelective(permission) == INTEGER_NUMBER_ONE) {
				return createMessageMap(SAVE, SUCCESS);
			}else {
				return createMessageMap(SAVE, ERROR);
			}
		}else {
			Permission currentPermission = permissionMapper.selectByPrimaryKey(permission.getId());
			if(currentPermission.getProhibition().equals(STRING_NUMBER_ZERO)) {
				throw new CustomException("无法编辑禁用状态下的数据");
			}
			permission.setMdifyTime(new Date());
			permission.setModifyUser(user.getNickName());
			if(permissionMapper.updateByPrimaryKeySelective(permission) == INTEGER_NUMBER_ONE) {
				return createMessageMap(EDIT, SUCCESS);
			}else {
				return createMessageMap(EDIT, ERROR);
			}
		}
	}

	@Override
	public Map<String, Object> optPermission(Integer permissionId) throws CustomException {
			
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
		
		if(permission == null) throw new CustomException("未知");
		
		String prohibition = permission.getProhibition();
		
		if(prohibition.equals(STRING_NUMBER_ONE)) permission.setProhibition(STRING_NUMBER_ZERO);
		
		if(prohibition.equals(STRING_NUMBER_ZERO)) permission.setProhibition(STRING_NUMBER_ONE);


		permission.setMdifyTime(new Date());
		permission.setModifyUser(user.getNickName());
		
		if(permissionMapper.updateByPrimaryKeySelective(permission) == INTEGER_NUMBER_ONE) {
			return createMessageMap(EDIT, SUCCESS);
		}else {
			return createMessageMap(EDIT, ERROR);
		}
	}

	@Override
	public Map<String, Object> delPermissionById(Integer permissionId) throws CustomException{
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
		permission.setModifyUser(user.getNickName());
		permission.setMdifyTime(new Date());
		permission.setStatus(STRING_NUMBER_ZERO);
		permission.setProhibition(STRING_NUMBER_ZERO);
		
		if(permissionMapper.updateByPrimaryKeySelective(permission) == INTEGER_NUMBER_ONE) {
			return createMessageMap(DEL, SUCCESS);
		}else {
			return createMessageMap(DEL, SUCCESS);
		}
	}

	@Override
	public List<Permission> loadPermission() throws CustomException{
		return permissionMapper.loadPermission();
	}

	@Override
	public List<Permission> getPermissionListByRoleId(Integer roleId)throws CustomException {
		return permissionMapper.getPermissionListByRoleId(roleId);
	}

	@Override
	public Map<String, Object> checkName(String name) throws CustomException{
		
		Permission permission = permissionMapper.checkName(name);
	
		if(isNotExist(permission)) return createMessageMap(5000, "权限名称已存在,请重新填写");
		
		else return createMessageMap(2000, "权限名称不存在,可以继续填写");
	
	}
}
