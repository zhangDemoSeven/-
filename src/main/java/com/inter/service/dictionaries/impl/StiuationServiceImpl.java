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
import com.inter.mapper.dictionaries.StiuationMapper;
import com.inter.pojo.dictionaries.Stiuation;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.StiuationService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class StiuationServiceImpl extends BaseService implements StiuationService {

	@Autowired
	private StiuationMapper stiuationMapper;

	@Override
	public List<Stiuation> getStiuationListByNoPage() throws CustomException{
		return stiuationMapper.getStiuationListByNoPage();
	}

	@Override
	public PageHelper<Stiuation> getStiuationListByPage(String name,Integer offset, Integer limit) {

		Integer total = stiuationMapper.getCount(name);
		
		List<Stiuation> list = stiuationMapper.getStiuationListByPage(name,offset,limit);
		
		return new PageHelper<Stiuation>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateStiuation(Stiuation stiuation) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(stiuation.getId())) {
			stiuation.setCreateTime(new Date());
			stiuation.setCreateUser(user.getNickName());
			stiuation.setModifyUser(user.getNickName());
			stiuation.setModifyTime(new Date());
			stiuation.setProhibition(STRING_NUMBER_ONE);
			stiuation.setStatus(STRING_NUMBER_ONE);
			
			if(stiuationMapper.insertSelective(stiuation) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			stiuation.setModifyUser(user.getNickName());
			stiuation.setModifyTime(new Date());
	
			if(stiuationMapper.updateByPrimaryKeySelective(stiuation) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Stiuation selectByPrimaryKey(Integer id) throws CustomException {
		return stiuationMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optStiuation(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Stiuation stiuation = stiuationMapper.selectByPrimaryKey(id);
		
		if(isExist(stiuation)) throw new CustomException("查询异常");
		
		String prohibition = stiuation.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) stiuation.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) stiuation.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		stiuation.setModifyTime(new Date());
		stiuation.setModifyUser(user.getNickName());
		
		if(stiuationMapper.updateByPrimaryKeySelective(stiuation) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delStiuation(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Stiuation stiuation = stiuationMapper.selectByPrimaryKey(id);
		
		if(isExist(stiuation)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		stiuation.setStatus(STRING_NUMBER_ZERO);
		stiuation.setProhibition(STRING_NUMBER_ZERO);
		stiuation.setModifyTime(new Date());
		stiuation.setModifyUser(user.getNickName());
		
		if(stiuationMapper.updateByPrimaryKeySelective(stiuation) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
