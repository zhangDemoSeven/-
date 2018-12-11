package com.inter.service.system;

import java.text.ParseException;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;

public interface StudentService {

	PageHelper<UserStudentVo> getOkOrNoStudentByPage(UserStudentVo userStudentVo,String identity, String isTemp,String userName,String queryDate,Integer user1,Integer user2,Integer user3, Integer offset, Integer limit) throws CustomException, ParseException;

	Map<String, Object> checkNickNameAndTelephoneA(String nickName, String telephoneA) throws CustomException;

	Map<String, Object> checkUsername(String username) throws CustomException;

	Map<String, Object> saveOrUpdateStudent(String[] roleIds, UserStudentVo vo) throws CustomException;

	UserStudentVo getUserByUserId(Integer userId)  throws CustomException;

	Map<String, Object> editIsTemp(Integer userId) throws CustomException, IllegalArgumentException, IllegalAccessException;

	Map<String, Object> checkClasses(Integer userId)  throws CustomException;

	Map<String, Object> addClasses(Integer classesId, Integer userId)  throws CustomException;

	Map<String, Object> addUser123(Integer userId, Integer types, Integer user123Id)throws CustomException;

	Map<String, Object> checkClassesExamination(Integer classesId) throws CustomException;

}
