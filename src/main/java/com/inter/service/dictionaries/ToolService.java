package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Tool;
import com.inter.utils.PageHelper;

public interface ToolService {

	List<Tool> getToolListByNoPage();

	Object selectByPrimaryKey(Integer id) throws CustomException;

	PageHelper<Tool> getToolListByPage(String name,Integer offset, Integer limit);

	Map<String, Object> saveOrUpdateTool(Tool tool) throws CustomException;

	Map<String, Object> optTool(Integer id) throws CustomException;

	Map<String, Object> delTool(Integer id) throws CustomException;

}
