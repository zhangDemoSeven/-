package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Questiontypes;
import com.inter.utils.PageHelper;

public interface QuestiontypesService {

	List<Questiontypes> getQuestiontypesListByNoPage()throws CustomException;

	Object selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Questiontypes> getQuestiontypesListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateQuestiontypes(Questiontypes questiontypes)throws CustomException;

	Map<String, Object> optQuestiontypes(Integer id)throws CustomException;

	Map<String, Object> delQuestiontypes(Integer id)throws CustomException;

}
