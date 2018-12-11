package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Education;

public interface EducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);

	List<Education> getEducationListByNoPage();

	Integer getCount(@Param("name")String name);

	List<Education> getEducationListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);

}