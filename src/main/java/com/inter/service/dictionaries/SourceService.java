package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Source;
import com.inter.utils.PageHelper;
import com.inter.vo.SourceVo;

public interface SourceService {

	List<SourceVo> getSourceListByNoPage( ) throws CustomException;

	Object selectByPrimaryKey(Integer id)throws CustomException;

	PageHelper<Source> getSourceListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Map<String, Object> saveOrUpdateSource(Source source, Integer pid)throws CustomException;

	Map<String, Object> optSource(Integer id)throws CustomException;

	Map<String, Object> delSource(Integer id)throws CustomException;

	Object selectParentList(Integer id);

	Source getParent(Integer channelId) throws CustomException;

}
