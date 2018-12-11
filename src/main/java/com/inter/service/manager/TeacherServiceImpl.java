package com.inter.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.school.ClassesMapper;
import com.inter.mapper.system.UserMapper;
import com.inter.pojo.school.Classes;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;


@Service
@Transactional
public class TeacherServiceImpl extends BaseService implements TeacherService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ClassesMapper classesMapper;
	
	@Override
	public List<User> getTeachListByIdentity(String identity) throws CustomException{
		return userMapper.getTeachListByIdentity(identity);
	}

	@Override
	public PageHelper<User> getTeacherListByPage(Integer classesId,String teacherName,Integer level,Integer queryIdentity,Integer offset, Integer limit) throws CustomException {
		
		if(isNotBlank(queryIdentity)) {
			if(queryIdentity.toString() == IDENTITY_STUDENT) return null;//想要查询学生信息,不可能 直接返回空数据
		}
		
		PageHelper<User> pageHelper = new PageHelper<User>();
		
		Integer total = userMapper.getTeacherCount(classesId,teacherName,level,queryIdentity,IDENTITY_STUDENT);
		
		List<User> list = userMapper.getTeacherListByPage(classesId,teacherName,level,queryIdentity,IDENTITY_STUDENT,offset,limit);
	
		//查询用户所管班级
		for (User teacher : list) {
			List<String> classesNameList = new ArrayList<String>();
			List<Classes> classesList = classesMapper.getClassesListByTeacherId(teacher.getId());
			for (Classes classes : classesList) {
				classesNameList.add(classes.getClassName());
			}
			
			String classesNames = StringUtils.join(classesNameList,",");
			teacher.setClassesNames(classesNames);
		} 
		
		pageHelper.setTotal(total);
		pageHelper.setRows(list);
		
		return pageHelper;
	}
}
