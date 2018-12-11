package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Source;

public interface SourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);

    List<Source> getParentSourceListByPidIsNull();

	List<Source> getParentSourceListByPid(@Param("parentId")Integer parentId);

	Integer getCount(@Param("name")String name);

	List<Source> getSourceListByPage(@Param("name")String name,@Param("offset")Integer offset,@Param("limit") Integer limit);

	List<Source> selectParentLsit(Integer id);

	Source selectParentById(Integer sourceId);
}