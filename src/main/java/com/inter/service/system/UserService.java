package com.inter.service.system;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.system.User;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;

public interface UserService {

	User findUserByUsername(String username);

	PageHelper<User> getUserListByPage(String userName,Integer offset, Integer limit) throws CustomException;

	User selectByPrimaryKey(Integer userId) throws CustomException;

	Map<String, Object> saveOrUpdateUser(String[] roleIds, User user) throws CustomException;

	Map<String, Object> optUser(Integer userId) throws CustomException;

	Map<String, Object> delUser(Integer userId) throws CustomException;

	List<User> getTeachListByIdentity(String identity) throws CustomException;

	PageHelper<User> getTeacherListByPage(Integer offset, Integer limit) throws CustomException;

	Map<String, Object> saveUser4Student(String[] roleIds,UserStudentVo vo) throws CustomException;

	Map<String, Object> checkNickNameAndTelephoneA(String nickName, String telephoneA) throws CustomException;

	Map<String, Object> userUnlock(String pwd)throws CustomException;

}
