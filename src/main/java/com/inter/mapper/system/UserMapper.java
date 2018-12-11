package com.inter.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.system.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findUserByUsername(@Param("username")String username);
	
	Integer getCount(@Param("userName")String userName);

	List<User> getUserListByPage(@Param("userName")String userName,@Param("offset")Integer offset, @Param("limit")Integer limit);

	void saveUserAndBackPrimaryKey(User user);

	List<User> getTeachListByIdentity(@Param("identity")String identity);

	Integer getTeacherCount(
			@Param("classesId")Integer classesId,
			@Param("teacherName")String teacherName,
			@Param("level")Integer level,
			@Param("queryIdentity")Integer queryIdentity,
			@Param("identity")String identity);

	List<User> getTeacherListByPage(
			@Param("classesId")Integer classesId,
			@Param("teacherName")String teacherName,
			@Param("level")Integer level,
			@Param("queryIdentity")Integer queryIdentity,
			@Param("identity")String identity, @Param("offset")Integer offset, @Param("limit")Integer limit);

	List<User> getTeacherListByClassesId(@Param("classesId")Integer classesId);

	User checkNickNameAndTelephoneA(@Param("nickName")String nickName, @Param("telephoneA")String telephoneA);

	User getUserByStudentId(@Param("studentId")Integer studentId);

	User checkUsername(@Param("username")String username);

}