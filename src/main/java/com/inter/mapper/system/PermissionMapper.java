package com.inter.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.Permission;

public interface PermissionMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> findAllPermissionList();

	List<Permission> findPermissionListByUserId(@Param("userId")Integer userId);
	
	Integer getCount(@Param("permissionName")String permissionName);

	List<Permission> getPermissionByPage(@Param("permissionName")String permissionName, @Param("offset")Integer offset,@Param("limit")Integer limit);

	List<Permission> loadPermission();

	List<Permission> getPermissionListByRoleId(@Param("roleId")Integer roleId);

	Permission checkName(@Param("name")String name);
}