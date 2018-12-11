package com.inter.mapper.school;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inter.pojo.school.Classes;

public interface ClassesMapper {
 
	int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

	List<Classes> getClassesListByTeacherId(@Param("teacherId")Integer teacherId);

	List<Classes> getClassesListByNoPage(@Param("ison")String ison);

	Integer getCount(@Param("teacherName")String teacherName,@Param("classesId")Integer classesId);

	List<Classes> getClassesListByPage(@Param("teacherName")String teacherName,@Param("classesId")Integer classesId,@Param("offset")Integer offset, @Param("limit")Integer limit);

	Classes getClassesByStudentId(@Param("studentId")Integer studentId);

	/** 根据id 查询对应的class*/
	Classes getClassesById(Integer id);

	List<Classes> getClassesListByTeacherIdAndExamId(@Param("teacherId")Integer id,@Param("examId") Integer examId);

	int selectExaminationCount(Integer classesId);
	
	//根据阶段ID查询班级
	List<Classes> getClassesByStage(Integer id);
}