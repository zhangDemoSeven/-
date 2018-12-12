package com.inter.service.paper;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.inter.exception.CustomException;
import com.inter.pojo.paper.Exam;

public interface ExamService {

	//获取所有考试信息
	PageInfo<Exam> getAllExams(Integer pageNum, Integer pageSize);
	
	//查询试卷状态
	List<Exam> getPaperStatus();
	
	//多条件查询
	List<Exam> getExamsByTerm(Exam exam) throws CustomException;
}
