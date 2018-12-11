package com.inter.service.dictionaries;

import java.util.List;
import java.util.Map;

import com.inter.exception.CustomException;
import com.inter.pojo.school.Classes;
import com.inter.utils.PageHelper;

public interface ClassesService {

	List<Classes> getClassesListByNoPage(String ison)throws CustomException;

	List<Classes> getClassesListByS1()throws CustomException;

	PageHelper<Classes> getClassesListByPage(String teacherName,Integer classesId,Integer page,Integer offset, Integer limit)throws CustomException;

	Object selectByPrimaryKey(Integer classesId)throws CustomException;

	Map<String, Object> saveOrUpdate(Classes classes, Integer teacherID, Integer assistantID, Integer headmasterID)throws CustomException;

	Map<String, Object> checkClassesNameById(String classesIds)throws CustomException;

	//根据阶段ID查询班级
	List<Classes> getClassesByStage(Integer id) throws CustomException;
}
