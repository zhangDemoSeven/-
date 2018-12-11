package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Stage;
import com.inter.utils.PageHelper;

public interface StageService {

	Object selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Stage> getStageListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateStage(Stage stage)throws CustomException;

	Map<String, Object> optStage(Integer id)throws CustomException;

	Map<String, Object> delStage(Integer id)throws CustomException;

	List<Stage> getStageListByNoPage()throws CustomException;

	//查询stage表中status为1的所有字段
	List<Stage> getAllStages() throws CustomException;
}
