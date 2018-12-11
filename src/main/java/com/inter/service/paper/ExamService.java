package com.inter.service.paper;

import com.github.pagehelper.PageInfo;
import com.inter.pojo.paper.Exam;

public interface ExamService {

	//获取所有考试信息
	PageInfo<Exam> getAllExams(Integer pageNum, Integer pageSize);
}