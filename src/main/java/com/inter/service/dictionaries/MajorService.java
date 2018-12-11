package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Major;
import com.inter.utils.PageHelper;

public interface MajorService {

	List<Major> getMajorListByNoPage() throws CustomException;

	Major selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Major> getMajorListByPage(String majorName,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateMajor(Major major)throws CustomException;

	Map<String, Object> optMajor(Integer id)throws CustomException;

	Map<String, Object> delMajor(Integer id)throws CustomException;

}
