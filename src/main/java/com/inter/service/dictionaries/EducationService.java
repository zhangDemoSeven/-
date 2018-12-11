package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Education;
import com.inter.utils.PageHelper;

public interface EducationService {

	List<Education> getEducationListByNoPage() throws CustomException;

	Object selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Education> getEducationListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateEducation(Education education)throws CustomException;

	Map<String, Object> optEducation(Integer id)throws CustomException;

	Map<String, Object> delEducation(Integer id)throws CustomException;

}
