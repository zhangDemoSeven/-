package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Questiontypes;

public interface QuestiontypesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questiontypes record);

    int insertSelective(Questiontypes record);

    Questiontypes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questiontypes record);

    int updateByPrimaryKey(Questiontypes record);

	List<Questiontypes> getQuestiontypesListByNoPage();

	Integer getCount(@Param("name")String name);

	List<Questiontypes> getQuestiontypesListByPage(@Param("name")String name,@Param("offset")Integer offset,@Param("limit") Integer limit);
}