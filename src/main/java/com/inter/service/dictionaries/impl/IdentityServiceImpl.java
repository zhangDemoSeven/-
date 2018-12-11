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
import com.inter.mapper.dictionaries.IdentityMapper;
import com.inter.pojo.dictionaries.Identity;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.IdentityService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class IdentityServiceImpl extends BaseService implements IdentityService {

	@Autowired
	private IdentityMapper identityMapper;


	@Override
	public List<Identity> getIdentityListNoPage() throws CustomException{
		return identityMapper.getIdentityListNoPage();
	}

	@Override
	public PageHelper<Identity> getListByPage(String name,Integer offset, Integer limit) {

		Integer total = identityMapper.getCount(name);
		
		List<Identity> list = identityMapper.getListByPage(name,offset,limit);
		
		return new PageHelper<Identity>(total,list);
	}

	@Override
	public Object selectByPrimaryKey(Integer id) {
		return identityMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> saveOrUpdateIdentity(Identity identity) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(identity.getId())) {
			identity.setCreateTime(new Date());
			identity.setCreateUser(user.getNickName());
			identity.setModifyUser(user.getNickName());
			identity.setModifyTime(new Date());
			identity.setProhibition(INTEGER_NUMBER_ONE);
			identity.setStatus(INTEGER_NUMBER_ONE);
			
			if(identityMapper.insertSelective(identity) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			identity.setModifyUser(user.getNickName());
			identity.setModifyTime(new Date());
	
			if(identityMapper.updateByPrimaryKeySelective(identity) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Map<String, Object> optIdentity(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Identity identity = identityMapper.selectByPrimaryKey(id);
		
		if(isExist(identity)) throw new CustomException("查询异常");
		
		Integer prohibition = identity.getProhibition();
		
		if(INTEGER_NUMBER_ONE == prohibition) identity.setProhibition(INTEGER_NUMBER_ZERO);
		
		if(INTEGER_NUMBER_ZERO == prohibition) identity.setProhibition(INTEGER_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		identity.setModifyTime(new Date());
		identity.setModifyUser(user.getNickName());
		
		if(identityMapper.updateByPrimaryKeySelective(identity) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delIdentity(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Identity identity = identityMapper.selectByPrimaryKey(id);
		
		if(isExist(identity)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		identity.setStatus(INTEGER_NUMBER_ZERO);
		identity.setProhibition(INTEGER_NUMBER_ZERO);
		identity.setModifyTime(new Date());
		identity.setModifyUser(user.getNickName());
		
		if(identityMapper.updateByPrimaryKeySelective(identity) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}
}
