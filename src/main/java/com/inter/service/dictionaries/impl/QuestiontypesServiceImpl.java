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
import com.inter.mapper.dictionaries.QuestiontypesMapper;
import com.inter.pojo.dictionaries.Questiontypes;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.QuestiontypesService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class QuestiontypesServiceImpl extends BaseService implements QuestiontypesService {

	@Autowired
	private QuestiontypesMapper questiontypesMapper;
	@Override
	public List<Questiontypes> getQuestiontypesListByNoPage() {
		return questiontypesMapper.getQuestiontypesListByNoPage();
	}

	@Override
	public PageHelper<Questiontypes> getQuestiontypesListByPage(String name,Integer offset, Integer limit) {

		Integer total = questiontypesMapper.getCount(name);
		
		List<Questiontypes> list = questiontypesMapper.getQuestiontypesListByPage(name,offset,limit);
		
		return new PageHelper<Questiontypes>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateQuestiontypes(Questiontypes questiontypes) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(questiontypes.getId())) {
			questiontypes.setCreateTime(new Date());
			questiontypes.setCreateBy(user.getNickName());
			questiontypes.setModifyBy(user.getNickName());
			questiontypes.setModifyTime(new Date());
			questiontypes.setProhibition(STRING_NUMBER_ONE);
			questiontypes.setStatus(STRING_NUMBER_ONE);
			
			if(questiontypesMapper.insertSelective(questiontypes) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			questiontypes.setModifyBy(user.getNickName());
			questiontypes.setModifyTime(new Date());
	
			if(questiontypesMapper.updateByPrimaryKeySelective(questiontypes) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Questiontypes selectByPrimaryKey(Integer id) throws CustomException {
		return questiontypesMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optQuestiontypes(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Questiontypes questiontypes = questiontypesMapper.selectByPrimaryKey(id);
		
		if(isExist(questiontypes)) throw new CustomException("查询异常");
		
		String prohibition = questiontypes.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) questiontypes.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) questiontypes.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		questiontypes.setModifyTime(new Date());
		questiontypes.setModifyBy(user.getNickName());
		
		if(questiontypesMapper.updateByPrimaryKeySelective(questiontypes) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delQuestiontypes(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Questiontypes questiontypes = questiontypesMapper.selectByPrimaryKey(id);
		
		if(isExist(questiontypes)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		questiontypes.setStatus(STRING_NUMBER_ZERO);
		questiontypes.setProhibition(STRING_NUMBER_ZERO);
		questiontypes.setModifyTime(new Date());
		questiontypes.setModifyBy(user.getNickName());
		
		if(questiontypesMapper.updateByPrimaryKeySelective(questiontypes) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
