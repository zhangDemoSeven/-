package com.inter.service.dictionaries.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.school.ClassesMapper;
import com.inter.mapper.school.UserAndClassesMapper;
import com.inter.mapper.system.UserMapper;
import com.inter.pojo.school.Classes;
import com.inter.pojo.school.UserAndClasses;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.ClassesService;
import com.inter.utils.PageHelper;


@Service
@Transactional
public class ClassesServiceImpl extends BaseService implements ClassesService {

	@Autowired
	private ClassesMapper classesMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAndClassesMapper userAndClassesMapper;
	
	@Override
	public List<Classes> getClassesListByNoPage(String ison) throws CustomException{
		return classesMapper.getClassesListByNoPage(ison);
	}

	@Override
	public List<Classes> getClassesListByS1() throws CustomException{
		
		List<Classes> newList = new ArrayList<Classes>();
		
		List<Classes> list = classesMapper.getClassesListByNoPage(STRING_NUMBER_ONE);
		if(isNotExist(list)) {
			for (Classes classes : list) {
				if(classes.getClassName().contains("S1")) {
					newList.add(classes);
				}
			}
		}
		return newList;
	}
	
	@Override
	public PageHelper<Classes> getClassesListByPage(String teacherName,Integer classesId,Integer page,Integer offset,Integer limit)throws CustomException {
		
		PageHelper<Classes> pageHelper = new PageHelper<>();
		
		Integer total = classesMapper.getCount(teacherName,classesId);
		
		List<Classes> list = classesMapper.getClassesListByPage(teacherName,classesId,offset,limit);
		if(list.size() >0) {
			for (Classes currClasses : list) {
				StringBuffer sb = new StringBuffer("");
				List<User> userList = userMapper.getTeacherListByClassesId(currClasses.getId());
				if(isNotExist(userList)) {
					for (User user : userList) {
						if(isNotExist(user)) {
							if(user.getIdentity().equals(IDENTITY_TEACHER)) {
								sb.append(user.getNickName()+",");
							}
							if(user.getIdentity().equals(IDENTITY_ASSISTANT)) {
								sb.append(user.getNickName()+",");
							}
							if(user.getIdentity().equals(IDENTITY_HEADMASTER)) {
								sb.append(user.getNickName());
							}
						}
					}
				}
				currClasses.setTeacherNames(sb.toString());
			}
		}
		
		pageHelper.setRows(list);
		pageHelper.setTotal(total);
		
		return pageHelper;
	}

	@Override
	public Object selectByPrimaryKey(Integer classesId)throws CustomException {
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		StringBuffer sb = new StringBuffer("");
		List<User> userList = userMapper.getTeacherListByClassesId(classesId);
		if(isNotExist(userList)) {
			for (User user : userList) {
				if(isNotExist(user)) {
					if(user.getIdentity().equals(IDENTITY_TEACHER)) {
						sb.append(user.getId()+",");
					}
					if(user.getIdentity().equals(IDENTITY_ASSISTANT)) {
						sb.append(user.getId()+",");
					}
					if(user.getIdentity().equals(IDENTITY_HEADMASTER)) {
						sb.append(user.getId());
					}
				}
			}
		}
		classes.setTeacherIds(sb.toString());
		 
		 return classes;
	}

	@Override
	public Map<String, Object> saveOrUpdate(Classes classes, Integer teacherID, Integer assistantID,Integer headmasterID) throws CustomException {
			
		
		
		if(isBlank(teacherID))	throw new CustomException("没有指定教员");
		if(isBlank(assistantID))throw new CustomException("没有指定助教");
		if(isBlank(headmasterID))throw new CustomException("没有指定班主任");
		
		if(classes.getId() == null) {
			
			classes.setIson(INTEGER_NUMBER_ONE);
			if(classesMapper.insertSelective(classes) == INTEGER_NUMBER_ONE) {
				
				Integer classesId = classes.getId();
				UserAndClasses uac1 = new UserAndClasses();
				uac1.setClassesId(classesId);
				uac1.setUserId(teacherID);
				userAndClassesMapper.insert(uac1);
				
				if(assistantID != null) {
					UserAndClasses uac2 = new UserAndClasses();
					uac2.setClassesId(classesId);
					uac2.setUserId(assistantID);
					userAndClassesMapper.insert(uac2);
				}
				
				UserAndClasses uac3 = new UserAndClasses();
				uac3.setClassesId(classesId);
				uac3.setUserId(headmasterID);
				userAndClassesMapper.insert(uac3);
				
				return createMessageMap(SAVE, SUCCESS);
			}else {
				throw new CustomException("保存失败");
			}
		}else {
			
			if(classesMapper.updateByPrimaryKeySelective(classes) == INTEGER_NUMBER_ONE) {
				
				Integer clssesId = classes.getId();
				List<UserAndClasses> uacList = userAndClassesMapper.getUserAndClassesByClassesId(classes.getId());
				if(uacList != null) {
					for (UserAndClasses userAndClasses : uacList) {
						Integer userAndClassesId = userAndClasses.getId();
						userAndClassesMapper.deleteByParmaryKeyAndClassesId(userAndClassesId,clssesId);
					}
				}
				
				UserAndClasses uac1 = new UserAndClasses();
				uac1.setClassesId(classes.getId());
				uac1.setUserId(teacherID);
				userAndClassesMapper.insert(uac1);
				
				if(assistantID != 9999) {
					UserAndClasses uac2 = new UserAndClasses();
					uac2.setClassesId(classes.getId());
					uac2.setUserId(assistantID);
					userAndClassesMapper.insert(uac2);
				}
				
				UserAndClasses uac3 = new UserAndClasses();
				uac3.setClassesId(classes.getId());
				uac3.setUserId(headmasterID);
				userAndClassesMapper.insert(uac3);
				
				return createMessageMap(EDIT, SUCCESS);
			}else {
				throw new CustomException("修改失败");
			}
		}
	}

	@Override
	public Map<String, Object> checkClassesNameById(String classesIds) throws CustomException {

		
		if(isBlank(classesIds)) throw new CustomException("传参异常");

		Set<String> nameSet = new HashSet<String>();
		List<String> nameSubstringSet = new ArrayList<String>();
		
		String[] classesIdArray = classesIds.split(",");
		for (String idStr : classesIdArray) {
			Integer id = Integer.parseInt(idStr);
			Classes classes = classesMapper.selectByPrimaryKey(id);
			nameSet.add(classes.getClassName());
		}
		
		if(isNotExist(nameSet)) {
			for (String name : nameSet) {
				nameSubstringSet.add(name.substring(0,2));
			}
		}
		//为了将集合转换成数组
		String join = StringUtils.join(nameSubstringSet,",");
		String[] split = join.split(",");
		boolean bool = isEquals(split);
		if(bool) {
			return createMessageMap(2000, "");
		}else{
			return createMessageMap(5000, "班级不在同一阶段,请重新选择");
		}
	}
	
}
