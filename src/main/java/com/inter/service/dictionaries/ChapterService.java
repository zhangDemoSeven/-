package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Chapter;
import com.inter.utils.PageHelper;

public interface ChapterService {

	PageHelper<Chapter> getChapterlistByPage(String name,Integer offset, Integer limit) throws CustomException;

	Map<String, Object> saveOrUpdateChapter(Chapter chapter) throws CustomException;

	Chapter selectPrimaryKey(Integer id)throws CustomException;

	Map<String, Object> optChapter(Integer id)throws CustomException;

	Map<String, Object> delChapter(Integer id)throws CustomException;

	List<Chapter> getChapterListByBooksId(Integer booksId);

}
