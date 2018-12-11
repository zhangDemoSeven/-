package com.inter.quartz.jobdetail;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.inter.exception.CustomException;
import com.inter.quartz.SimpleService;
import com.inter.utils.QuartzUtil;



/**
 * @ClassName AutoStopExamJobBean
 * @Description 到时间自动开始考试的JOB 
 * @Date 2018年11月27日 下午10:21:29
 */
public class AutoStartExamJobBean extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		
		SimpleService simpleService = QuartzUtil.getApplicationContext(jobexecutioncontext).getBean("simpleService",
				SimpleService.class);
		try {
			simpleService.startExam(jobexecutioncontext);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

}
