package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Stiuation;
import com.inter.utils.PageHelper;

public interface StiuationService {

	List<Stiuation> getStiuationListByNoPage()throws CustomException;

	PageHelper<Stiuation> getStiuationListByPage(String name,Integer offset, Integer limit);

	Map<String, Object> saveOrUpdateStiuation(Stiuation stiuation) throws CustomException;

	Stiuation selectByPrimaryKey(Integer id) throws CustomException;

	Map<String, Object> optStiuation(Integer id) throws CustomException;

	Map<String, Object> delStiuation(Integer id)throws CustomException;

}
