package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Books;
import com.inter.utils.PageHelper;

public interface BooksService {

	List<Books> getBooksListByNoPage()throws CustomException;

	Books selectByPrimaryKey(Integer id);

	PageHelper<Books> getBooksListByPage(String booksName,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateBooks(Books books)throws CustomException;

	Map<String, Object> optBooks(Integer id)throws CustomException;

	Map<String, Object> delBooks(Integer id)throws CustomException;

	List<Books> getBooksListByStageId(Integer stageId)throws CustomException;

}
