package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Tool;

public interface ToolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tool record);

    int insertSelective(Tool record);

    Tool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tool record);

    int updateByPrimaryKey(Tool record);

	List<Tool> getToolListByNoPage();

	Integer getCount(@Param("name")String name);

	List<Tool> getToolListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);
}