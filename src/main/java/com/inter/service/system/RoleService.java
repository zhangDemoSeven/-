package com.inter.service.system;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.system.Role;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;

public interface RoleService {

	List<Role> findRoleByUser(User user);

	PageHelper<Role> getRoleListByPage(String roleName,Integer offset, Integer limit)throws CustomException;

	Role selectByPrimaryKey(Integer roleId)throws CustomException;

	Map<String, Object> saveOrUpdateRole(String[] permissionIds, String[] menuIds, Role role)throws CustomException;

	Map<String, Object> optRole(Integer roleId)throws CustomException;

	Map<String, Object> delRole(Integer roleId)throws CustomException;

	List<Role> getRoleListNoPage()throws CustomException;

	Map<String, Object> checkName(String name)throws CustomException;

}
