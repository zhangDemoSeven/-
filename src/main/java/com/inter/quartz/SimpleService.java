package com.inter.quartz;

import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;

import com.inter.exception.CustomException;

@Service("simpleService")
public class SimpleService {
	
	//@Autowired
	//MonthPaperService monthPaperService;
	
	
	/**
	 * @Description: 
	 * 			到时见根据考试ID开始考试
	 * @param context 
	 * 			调度器的综合对象
	 * @throws CustomException 
	 */
	
	public void startExam(JobExecutionContext context) throws CustomException {
		//monthPaperService.startExam(context.getTrigger().getJobDataMap().getInt("examId"));
	}
	
	
	
	/**
	 * @Description: 
	 * 			到时见根据考试ID结束考试，
	 * 			为确保学生试卷数据提交完毕，执行结束会比定义的考试结束时间晚2分钟
	 * @param context 
	 * 			调度器的综合对象
	 */
	
	public void stopExam(JobExecutionContext context) throws CustomException {
		//monthPaperService.stopExam(context.getTrigger().getJobDataMap().getInt("examId"));
	}

}
