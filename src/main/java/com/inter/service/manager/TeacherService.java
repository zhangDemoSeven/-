package com.inter.service.manager;

import java.util.List;

import com.inter.exception.CustomException;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;


public interface TeacherService {

	List<User> getTeachListByIdentity(String identity)throws CustomException;

	PageHelper<User> getTeacherListByPage(Integer classesId,String teacherName, Integer level,Integer identity, Integer offset, Integer limit) throws CustomException;
}
