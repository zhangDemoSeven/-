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
import com.inter.mapper.dictionaries.MajorMapper;
import com.inter.pojo.dictionaries.Major;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.MajorService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class MajorServiceImpl extends BaseService implements MajorService {

	@Autowired
	private MajorMapper majorMapper;

	@Override
	public List<Major> getMajorListByNoPage() throws CustomException{
		return majorMapper.getMajorListByNoPage();
	}
	

	@Override
	public PageHelper<Major> getMajorListByPage(String majorName,Integer offset, Integer limit) {

		Integer total = majorMapper.getCount(majorName);
		
		List<Major> list = majorMapper.getMajorListByPage(majorName,offset,limit);
		
		return new PageHelper<Major>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateMajor(Major major) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(major.getId())) {
			major.setCreateTime(new Date());
			major.setCreateUser(user.getNickName());
			major.setModifyUser(user.getNickName());
			major.setModifyTime(new Date());
			major.setProhibition(STRING_NUMBER_ONE);
			major.setStatus(STRING_NUMBER_ONE);
			
			if(majorMapper.insertSelective(major) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			major.setModifyUser(user.getNickName());
			major.setModifyTime(new Date());
	
			if(majorMapper.updateByPrimaryKeySelective(major) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Major selectByPrimaryKey(Integer id) throws CustomException {
		return majorMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optMajor(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Major major = majorMapper.selectByPrimaryKey(id);
		
		if(isExist(major)) throw new CustomException("查询异常");
		
		String prohibition = major.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) major.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) major.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		major.setModifyTime(new Date());
		major.setModifyUser(user.getNickName());
		
		if(majorMapper.updateByPrimaryKeySelective(major) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delMajor(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Major major = majorMapper.selectByPrimaryKey(id);
		
		if(isExist(major)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		major.setStatus(STRING_NUMBER_ZERO);
		major.setProhibition(STRING_NUMBER_ZERO);
		major.setModifyTime(new Date());
		major.setModifyUser(user.getNickName());
		
		if(majorMapper.updateByPrimaryKeySelective(major) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
