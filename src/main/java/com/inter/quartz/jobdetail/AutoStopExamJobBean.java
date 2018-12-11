package com.inter.quartz.jobdetail;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.inter.exception.CustomException;
import com.inter.quartz.SimpleService;
import com.inter.utils.QuartzUtil;



/**
 * @ClassName AutoStopExamJobBean
 * @Description 到时间自动停止考试的JOB 
 */

public class AutoStopExamJobBean extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		
		SimpleService simpleService = QuartzUtil.getApplicationContext(jobexecutioncontext).getBean("simpleService",
				SimpleService.class);
		try {
			synchronized (simpleService) {
				simpleService.stopExam(jobexecutioncontext);
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

}
