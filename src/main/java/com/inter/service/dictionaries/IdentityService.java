package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.dictionaries.Identity;
import com.inter.utils.PageHelper;

public interface IdentityService {

	List<Identity> getIdentityListNoPage() throws CustomException;

	PageHelper<Identity> getListByPage(String name,Integer offset, Integer limit)throws CustomException;

	Object selectByPrimaryKey(Integer id)throws CustomException;

	Map<String, Object> saveOrUpdateIdentity(Identity identity) throws CustomException;

	Map<String, Object> optIdentity(Integer id)throws CustomException;

	Map<String, Object> delIdentity(Integer id)throws CustomException;

}
