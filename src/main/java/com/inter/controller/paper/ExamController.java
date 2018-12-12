package com.inter.controller.paper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.pojo.paper.Exam;
import com.inter.service.paper.ExamService;

@RestController
@RequestMapping("/exam/")
public class ExamController extends BaseController {
	
	@Autowired
	private ExamService examService;
	
	/**
	 * @Title: getAllExams
	 * @Description: TODO:数据表格统一接口
	 * @param @param pageNum
	 * @param @param pageSize
	 * @param @return    参数
	 * @return JSONObject    返回类型
	 * @throws
	 */
	@RequestMapping("/getAllExams.do")
	public JSONObject getAllExams(@RequestParam(value="page",defaultValue="1") Integer pageNum, 
			@RequestParam(value="limit",defaultValue="10")Integer pageSize) {
		PageInfo<Exam> exams = examService.getAllExams(pageNum, pageSize);
		JSONObject obj = new JSONObject();
		obj.put("code",0);
		obj.put("msg","success");
		obj.put("count",exams.getTotal());
		obj.put("data",exams);
		System.err.println(obj.toJSONString());
		return obj;
	}
	
	@RequestMapping("/getPaperStatus.do")
	public List<Exam> getPaperStatus() {
		List<Exam> status = examService.getPaperStatus();
		System.err.println(status);
		return status == null ? null : status;
	}
	
	@RequestMapping("/getExamsByTerm.do")
	public List<Exam> getExamsByTerm(Exam exam) throws CustomException {
		List<Exam> exams = examService.getExamsByTerm(exam);
		System.err.println(exams);
		return exams == null ? null : exams;
	}
}
