package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Chapter;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);


    Integer getCount(@Param("name") String name);

	List<Chapter> getChapterListByPage(@Param("name")String name,@Param("offset")Integer offset, @Param("limit")Integer limit);
    
	List<Chapter> getChapterListByBooksId(@Param("booksId")Integer booksId);
}