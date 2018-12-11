package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Stiuation;

public interface StiuationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stiuation record);

    int insertSelective(Stiuation record);

    Stiuation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stiuation record);

    int updateByPrimaryKey(Stiuation record);

	List<Stiuation> getStiuationListByNoPage();

	Integer getCount(@Param("name")String name);

	List<Stiuation> getStiuationListByPage(@Param("name")String name,@Param("offset")Integer offset,@Param("limit") Integer limit);
}