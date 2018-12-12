package com.inter.service.paper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.paper.ExamMapper;
import com.inter.pojo.paper.Exam;
import com.inter.service.paper.ExamService;

@Service
@Transactional
public class ExamServiceImpl extends BaseService implements ExamService {

	@Autowired
	private ExamMapper examMapper;
	
	//获取所有考试信息
	@Override
	public PageInfo<Exam> getAllExams(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Exam> exams = examMapper.getAllExams();
		System.err.println(exams);
		return new PageInfo<Exam>(exams);
	}

	
	//查询试卷状态
	@Override
	public List<Exam> getPaperStatus() {
		List<Exam> status = examMapper.getPaperStatus();
		return status == null ? null : status;
	}


	//多条件查询
	@Override
	public List<Exam> getExamsByTerm(Exam exam) throws CustomException {
		List<Exam> list = examMapper.getExamsByTerm(exam);
		return list == null ? null:list;
	}
	
}
