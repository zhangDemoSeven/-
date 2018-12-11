package com.inter.service.dictionaries.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.dictionaries.ToolMapper;
import com.inter.pojo.dictionaries.Tool;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.ToolService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class ToolServiceImpl extends BaseService implements ToolService {

	@Autowired
	private ToolMapper toolMapper;

	@Override
	public List<Tool> getToolListByNoPage() {
		return toolMapper.getToolListByNoPage();
	}

	@Override
	public PageHelper<Tool> getToolListByPage(String name,Integer offset, Integer limit) {

		Integer total = toolMapper.getCount(name);
		
		List<Tool> list = toolMapper.getToolListByPage(name,offset,limit);
		
		return new PageHelper<Tool>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateTool(Tool tool) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(tool.getId())) {
			tool.setCreateTime(new Date());
			tool.setCreateUser(user.getNickName());
			tool.setModifyUser(user.getNickName());
			tool.setModifyTime(new Date());
			tool.setProhibition(STRING_NUMBER_ONE);
			tool.setStatus(STRING_NUMBER_ONE);
			
			if(toolMapper.insertSelective(tool) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			tool.setModifyUser(user.getNickName());
			tool.setModifyTime(new Date());
	
			if(toolMapper.updateByPrimaryKeySelective(tool) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Tool selectByPrimaryKey(Integer id) throws CustomException {
		return toolMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optTool(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Tool tool = toolMapper.selectByPrimaryKey(id);
		
		if(isExist(tool)) throw new CustomException("查询异常");
		
		String prohibition = tool.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) tool.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) tool.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		tool.setModifyTime(new Date());
		tool.setModifyUser(user.getNickName());
		
		if(toolMapper.updateByPrimaryKeySelective(tool) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delTool(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Tool tool = toolMapper.selectByPrimaryKey(id);
		
		if(isExist(tool)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		tool.setStatus(STRING_NUMBER_ZERO);
		tool.setProhibition(STRING_NUMBER_ZERO);
		tool.setModifyTime(new Date());
		tool.setModifyUser(user.getNickName());
		
		if(toolMapper.updateByPrimaryKeySelective(tool) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
	
	
}
