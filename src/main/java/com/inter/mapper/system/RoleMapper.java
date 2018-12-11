package com.inter.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.Role;

public interface RoleMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> findAllRoleList();

	List<Role> findRoleListByUserId(@Param("userId")Integer userId);
	
	Integer getCountByPage(@Param("roleName")String roleName);

	List<Role> getRoleListByPage(@Param("roleName")String roleName,@Param("offset")Integer offset,@Param("limit")Integer limit);

	void insertBackPrimaryKey(Role role);

	List<Role> getRoleListNoPage();

	List<Role> getRoleListByUserId(@Param("userId")Integer userId);

	List<Role> checkName(@Param("name")String name);
	
}