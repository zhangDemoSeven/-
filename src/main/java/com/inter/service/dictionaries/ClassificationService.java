package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Classification;
import com.inter.utils.PageHelper;

public interface ClassificationService {

	List<Classification> getClassificationListByNoPage() throws CustomException;

	PageHelper<Classification> getClassificationListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateClassification(Classification classification)throws CustomException;

	Map<String, Object> optClassification(Integer id)throws CustomException;

	Map<String, Object> delClassification(Integer id)throws CustomException;

	Object selectByPrimaryKey(Integer id)throws CustomException;

}
