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
import com.inter.mapper.dictionaries.StageMapper;
import com.inter.pojo.dictionaries.Stage;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.StageService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class StageServiceImpl extends BaseService implements StageService {

	@Autowired
	private StageMapper stageMapper;

	@Override
	public PageHelper<Stage> getStageListByPage(String name,Integer offset, Integer limit) {

		Integer total = stageMapper.getCount(name);
		
		List<Stage> list = stageMapper.getStageListByPage(name,offset,limit);
		
		return new PageHelper<Stage>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateStage(Stage stage) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(stage.getId())) {
			stage.setCreateTime(new Date());
			stage.setCreateUser(user.getNickName());
			stage.setModifyUser(user.getNickName());
			stage.setMdifyTime(new Date());
			stage.setProhibition(STRING_NUMBER_ONE);
			stage.setStatus(STRING_NUMBER_ONE);
			
			if(stageMapper.insertSelective(stage) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			stage.setModifyUser(user.getNickName());
			stage.setMdifyTime(new Date());
	
			if(stageMapper.updateByPrimaryKeySelective(stage) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Stage selectByPrimaryKey(Integer id) throws CustomException {
		return stageMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optStage(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Stage stage = stageMapper.selectByPrimaryKey(id);
		
		if(isExist(stage)) throw new CustomException("查询异常");
		
		String prohibition = stage.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) stage.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) stage.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		stage.setMdifyTime(new Date());
		stage.setModifyUser(user.getNickName());
		
		if(stageMapper.updateByPrimaryKeySelective(stage) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delStage(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Stage stage = stageMapper.selectByPrimaryKey(id);
		
		if(isExist(stage)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		stage.setStatus(STRING_NUMBER_ZERO);
		stage.setProhibition(STRING_NUMBER_ZERO);
		stage.setMdifyTime(new Date());
		stage.setModifyUser(user.getNickName());
		
		if(stageMapper.updateByPrimaryKeySelective(stage) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}

	@Override
	public List<Stage> getStageListByNoPage() throws CustomException {
		return stageMapper.getStageListByNoPage();
	}
}
