package com.inter.mapper.school;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.school.UserAndClasses;

public interface UserAndClassesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAndClasses record);

    int insertSelective(UserAndClasses record);

    UserAndClasses selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAndClasses record);

    int updateByPrimaryKey(UserAndClasses record);

    List<UserAndClasses> getUserAndClassesByClassesId(@Param("classesId")Integer classesId);

	void deleteByParmaryKeyAndClassesId(@Param("userAndClassesId")Integer userAndClassesId, @Param("classesId")Integer clssesId);

	/** 根据教师id查询所带班级ID*/
	List<Integer> getClassIdListByUserId(Integer id);

}