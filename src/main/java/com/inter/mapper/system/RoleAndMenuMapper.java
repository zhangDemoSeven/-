package com.inter.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.RoleAndMenuKey;

public interface RoleAndMenuMapper {
	
    int deleteByPrimaryKey(RoleAndMenuKey key);

    int insert(RoleAndMenuKey record);

    int insertSelective(RoleAndMenuKey record);
    
    RoleAndMenuKey getRoleAndMenuByMenuIdAndRoleId(@Param("menuId")Integer menuId, @Param("roleId")Integer roleId);

    void deleteRoleAndMenuByRoleIdAndMenuId(@Param("roleId")Integer roleId, @Param("menuId")Integer menuId);
}