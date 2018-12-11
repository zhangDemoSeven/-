package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);

	List<Level> getLevelListByNoPage();

	Integer getCount(@Param("name")String name);

	List<Level> getListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);
}