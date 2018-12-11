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
import com.inter.mapper.dictionaries.LevelMapper;
import com.inter.pojo.dictionaries.Level;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.LevelService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class LevelServiceImpl extends BaseService implements LevelService {

	@Autowired
	private LevelMapper levelMapper;

	@Override
	public List<Level> getLevelListByNoPage() throws CustomException{
		return levelMapper.getLevelListByNoPage();
	}

	@Override
	public PageHelper<Level> getListByPage(String name,Integer offset, Integer limit) throws CustomException{
		
		Integer total = levelMapper.getCount(name);
		
		List<Level> list = levelMapper.getListByPage(name,offset,limit);
		
		return new PageHelper<>(total,list);
	}

	@Override
	public Level selectByPrimaryKey(Integer id) throws CustomException {
		return levelMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> saveOrUpdateLevel(Level level) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(level.getId())) {
			level.setCreateTime(new Date());
			level.setCreateUser(user.getNickName());
			level.setModifyUser(user.getNickName());
			level.setModifyTime(new Date());
			level.setProhibition(INTEGER_NUMBER_ONE);
			level.setStatus(INTEGER_NUMBER_ONE);
			
			if(levelMapper.insertSelective(level) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			level.setModifyUser(user.getNickName());
			level.setModifyTime(new Date());
	
			if(levelMapper.updateByPrimaryKeySelective(level) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Map<String, Object> optLevel(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Level level = levelMapper.selectByPrimaryKey(id);
		
		if(isExist(level)) throw new CustomException("查询异常");
		
		Integer prohibition = level.getProhibition();
		
		if(INTEGER_NUMBER_ONE == prohibition) level.setProhibition(INTEGER_NUMBER_ZERO);
		
		if(INTEGER_NUMBER_ZERO == prohibition) level.setProhibition(INTEGER_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		level.setModifyTime(new Date());
		level.setModifyUser(user.getNickName());
		
		if(levelMapper.updateByPrimaryKeySelective(level) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delLevel(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Level level = levelMapper.selectByPrimaryKey(id);
		
		if(isExist(level)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		level.setStatus(INTEGER_NUMBER_ZERO);
		level.setProhibition(INTEGER_NUMBER_ZERO);
		level.setModifyTime(new Date());
		level.setModifyUser(user.getNickName());
		
		if(levelMapper.updateByPrimaryKeySelective(level) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
