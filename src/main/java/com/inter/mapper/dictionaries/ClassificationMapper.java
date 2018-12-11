package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Classification;

public interface ClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classification record);

    int insertSelective(Classification record);

    Classification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);

	List<Classification> getClassificationListByNoPage();

	Integer getCount(@Param("name") String name);

	List<Classification> getClassificationListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);
}