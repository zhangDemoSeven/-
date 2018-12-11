package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Level;
import com.inter.utils.PageHelper;

public interface LevelService {

	PageHelper<Level> getListByPage(String name,Integer offset, Integer limit)throws CustomException;

	List<Level> getLevelListByNoPage()throws CustomException;

	Level selectByPrimaryKey(Integer id)throws CustomException;

	Map<String, Object> saveOrUpdateLevel(Level level)throws CustomException;

	Map<String, Object> optLevel(Integer id)throws CustomException;

	Map<String, Object> delLevel(Integer id)throws CustomException;

}
