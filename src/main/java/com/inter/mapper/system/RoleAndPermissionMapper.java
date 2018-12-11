package com.inter.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.RoleAndPermissionKey;

public interface RoleAndPermissionMapper {
    int deleteByPrimaryKey(RoleAndPermissionKey key);

    int insert(RoleAndPermissionKey record);

    int insertSelective(RoleAndPermissionKey record);
    
    /**保存角色相关: 通过角色id删除实体信息*/
    void deleteRoleAndPermissionByRoleIdAndPermissionId(@Param("roleId")Integer roleId, @Param("permissionId")Integer permissionId);
}