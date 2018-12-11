package com.inter.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.UserAndRoleKey;

public interface UserAndRoleMapper {
    int deleteByPrimaryKey(UserAndRoleKey key);

    int insert(UserAndRoleKey record);

    int insertSelective(UserAndRoleKey record);

    void deleteByUserId(@Param("userId")Integer userId);
}