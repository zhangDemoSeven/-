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
import com.inter.mapper.dictionaries.EducationMapper;
import com.inter.pojo.dictionaries.Education;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.EducationService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class EducationServiceImpl extends BaseService implements EducationService {

	@Autowired
	private EducationMapper  educationMapper;

	@Override
	public List<Education> getEducationListByNoPage() throws CustomException{
		return educationMapper.getEducationListByNoPage();
	}
	
	@Override
	public PageHelper<Education> getEducationListByPage(String name,Integer offset, Integer limit) {

		Integer total = educationMapper.getCount(name);
		
		List<Education> list = educationMapper.getEducationListByPage(name,offset,limit);
		
		return new PageHelper<Education>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateEducation(Education education) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(education.getId())) {
			education.setCreateTime(new Date());
			education.setCreateUser(user.getNickName());
			education.setModifyUser(user.getNickName());
			education.setModifyTime(new Date());
			education.setProhibition(STRING_NUMBER_ONE);
			education.setStatus(STRING_NUMBER_ONE);
			
			if(educationMapper.insertSelective(education) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			education.setModifyUser(user.getNickName());
			education.setModifyTime(new Date());
	
			if(educationMapper.updateByPrimaryKeySelective(education) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Education selectByPrimaryKey(Integer id) throws CustomException {
		return educationMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optEducation(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Education education = educationMapper.selectByPrimaryKey(id);
		
		if(isExist(education)) throw new CustomException("查询异常");
		
		String prohibition = education.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) education.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) education.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		education.setModifyTime(new Date());
		education.setModifyUser(user.getNickName());
		
		if(educationMapper.updateByPrimaryKeySelective(education) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delEducation(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Education education = educationMapper.selectByPrimaryKey(id);
		
		if(isExist(education)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		education.setStatus(STRING_NUMBER_ZERO);
		education.setProhibition(STRING_NUMBER_ZERO);
		education.setModifyTime(new Date());
		education.setModifyUser(user.getNickName());
		
		if(educationMapper.updateByPrimaryKeySelective(education) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
