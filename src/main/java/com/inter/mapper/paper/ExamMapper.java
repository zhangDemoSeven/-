package com.inter.mapper.paper;

import java.util.List;

import com.inter.pojo.paper.Exam;

/**
 * @ClassName: ExamMapper
 * @Description: TODO:考试相关
 * @author 孙佳伟
 * @date 2018年12月11日
 */
public interface ExamMapper {

	//获取所有考试信息
	List<Exam> getAllExams();
	
	//查询试卷状态
	List<Exam> getPaperStatus();
	
	//多条件查询
	List<Exam> getExamsByTerm(Exam exam);
}
