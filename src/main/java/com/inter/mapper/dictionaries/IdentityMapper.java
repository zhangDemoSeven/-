package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Identity;

public interface IdentityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);

	List<Identity> getIdentityListNoPage();

	Integer getCount(@Param("name")String name);

	List<Identity> getListByPage(@Param("name")String name,@Param("offset")Integer offset,@Param("limit") Integer limit);
}