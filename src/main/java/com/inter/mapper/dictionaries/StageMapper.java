package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Stage;

public interface StageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stage record);

    int insertSelective(Stage record);

    Stage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stage record);

    int updateByPrimaryKey(Stage record);

	Integer getCount(@Param("name")String name);

	List<Stage> getStageListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);

	List<Stage> getStageListByNoPage();

	Stage getStageByBooksId(@Param("booksId")Integer booksId);

	//查询stage表中status为1的所有字段
	List<Stage> getAllStages();
}