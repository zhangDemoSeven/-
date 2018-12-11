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
import com.inter.mapper.dictionaries.ClassificationMapper;
import com.inter.pojo.dictionaries.Classification;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.ClassificationService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class ClassificationServiceImpl extends BaseService implements ClassificationService {

	@Autowired
	private ClassificationMapper classificationMapper;

	@Override
	public List<Classification> getClassificationListByNoPage() throws CustomException {
		return classificationMapper.getClassificationListByNoPage();
	}

	@Override
	public PageHelper<Classification> getClassificationListByPage(String name,Integer offset, Integer limit)
			throws CustomException {

		Integer total = classificationMapper.getCount(name);
		
		List<Classification> list = classificationMapper.getClassificationListByPage(name,offset,limit);
		
		return new PageHelper<Classification>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateClassification(Classification classification) throws CustomException {
User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(classification.getId())) {
			classification.setCreateTime(new Date());
			classification.setCreateUser(user.getNickName());
			classification.setModifyUser(user.getNickName());
			classification.setModifyTime(new Date());
			classification.setProhibition(INTEGER_NUMBER_ONE);
			classification.setStatus(INTEGER_NUMBER_ONE);
			
			if(classificationMapper.insertSelective(classification) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			classification.setModifyUser(user.getNickName());
			classification.setModifyTime(new Date());
	
			if(classificationMapper.updateByPrimaryKeySelective(classification) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Map<String, Object> optClassification(Integer id) throws CustomException {

		if(isBlank(id)) throw new CustomException("传参异常");
		
		Classification classification = classificationMapper.selectByPrimaryKey(id);
		
		if(isExist(classification)) throw new CustomException("查询异常");
		
		Integer prohibition = classification.getProhibition();
		
		if(INTEGER_NUMBER_ONE == prohibition) classification.setProhibition(INTEGER_NUMBER_ZERO);
		
		if(INTEGER_NUMBER_ZERO == prohibition) classification.setProhibition(INTEGER_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		classification.setModifyTime(new Date());
		classification.setModifyUser(user.getNickName());
		
		if(classificationMapper.updateByPrimaryKeySelective(classification) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
	}

	@Override
	public Map<String, Object> delClassification(Integer id) throws CustomException {

		if(isBlank(id)) throw new CustomException("传参异常");
		
		Classification classification = classificationMapper.selectByPrimaryKey(id);
		
		if(isExist(classification)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		classification.setStatus(INTEGER_NUMBER_ZERO);
		classification.setProhibition(INTEGER_NUMBER_ZERO);
		classification.setModifyTime(new Date());
		classification.setModifyUser(user.getNickName());
		
		if(classificationMapper.updateByPrimaryKeySelective(classification) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
	}

	@Override
	public Classification selectByPrimaryKey(Integer id) throws CustomException {
		return classificationMapper.selectByPrimaryKey(id);
	}
}
