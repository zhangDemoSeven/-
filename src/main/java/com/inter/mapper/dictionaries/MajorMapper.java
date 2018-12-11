package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

	List<Major> getMajorListByNoPage();

	Integer getCount(@Param("majorName")String majorName);

	List<Major> getMajorListByPage(@Param("majorName")String majorName,@Param("offset")Integer offset,@Param("limit") Integer limit);
}