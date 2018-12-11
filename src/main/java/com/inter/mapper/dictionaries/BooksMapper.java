package com.inter.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.dictionaries.Books;

public interface BooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);

	List<Books> getBooksListByNoPage();

	Integer getCount(@Param("booksName")String booksName);

	List<Books> getBooksListByPage(@Param("booksName")String booksName,@Param("offset")Integer offset, @Param("limit")Integer limit);

	List<Books> getBooksListByStageId(@Param("stageId")Integer stageId);
}