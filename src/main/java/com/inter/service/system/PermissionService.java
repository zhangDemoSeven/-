package com.inter.service.system;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.system.Permission;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;

public interface PermissionService {

	List<Permission> findPermissionByUser(User user);
	
	Permission selectByPrimaryKey(Integer permissionId)throws CustomException;

	Map<String, Object> saveOrUpdatePermission(Permission permission)throws CustomException;

	Map<String, Object> optPermission(Integer permissionId)throws CustomException;

	Map<String, Object> delPermissionById(Integer permissionId)throws CustomException;

	List<Permission> loadPermission()throws CustomException;

	List<Permission> getPermissionListByRoleId(Integer roleId)throws CustomException;

	PageHelper<Permission> getPermissionByPage(String permissionName,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> checkName(String name)throws CustomException;
}
