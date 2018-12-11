package com.inter.mapper.school;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.school.Student;
import com.inter.vo.UserStudentVo;

public interface StudentMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	Student getStudentByUserId(@Param("userId")Integer userId);

	Integer getOkOrNoStudentCount(
			@Param("identity")String identity , 
			@Param("isTemp")String isTemp,
			@Param("userName")String userName,
			@Param("startDate")Date startDate,
			@Param("endDate")Date endDate,
			@Param("user1")Integer user1,
			@Param("user2")Integer user2,
			@Param("user3")Integer user3
			);

	List<UserStudentVo> getOkOrNoStudentByPage(UserStudentVo userStudentVo, 
			@Param("identity")String identity,
			@Param("isTemp")String isTemp, 
			@Param("userName")String userName,
			@Param("startDate")Date startDate,
			@Param("endDate")Date endDate,
			@Param("user1")Integer user1,
			@Param("user2")Integer user2,
			@Param("user3")Integer user3,
			@Param("offset")Integer offset,
			@Param("limit") Integer limit);

	List<Student> getStudentListNoPage();

	List<Student> getStudentByClassesId(@Param("classesId")Integer classesId);
}