package com.inter.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

/** 调度器工具类*/
public class QuartzUtil {
	
	

	/**
	 * @Description: 根据试卷ID 获得开始试卷定时器的triggerName
	 * @param examId 试卷ID
	 * @return 返回开始考试定时任务名称，根据该名称删除调度器
	 */
	public static String getStartExamTriggerName(Integer examId) {
		return "START_EXAM_"+examId;
	}
	
	
	/**
	 * @Description: 根据试卷ID 获得开始试卷定时器的triggerName
	 * @param examId 试卷ID
	 * @return 返回开始考试定时任务名称，根据该名称删除调度器
	 */
	public static String getStopExamTriggerName(Integer examId) {
		return "STOP_EXAM_"+examId;
	}
	
	
	/**
	 * @Description: 获得系统ApplicationContext对象
	 * @param jobexecutioncontext 调度器综合对象
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext(final JobExecutionContext jobexecutioncontext) {
		try {
			return (ApplicationContext) jobexecutioncontext.getScheduler().getContext().get("applicationContextKey");
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @Description: 创建一个JobDetail任务详情
	 * @date 2018年11月27日 下午10:10:25
	 * @param jobClass 要执行Job的class
	 * @param jobName 任务名称
	 * @param jobGroup 任务组
	 * @return 返回任务对象
	 */
	public static JobDetail createJob(Class <? extends Job> jobClass,String jobName,String jobGroup) {
		
		JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
		
		jobBuilder.storeDurably();
		
		jobBuilder.withIdentity(jobName, jobGroup);
		
		return jobBuilder.build();
	}
	
	

	/***
	 * @param date
	 * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss 只接受此格式
	 * @return
	 */
	public static String formatDateByPattern(Date date,String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatTimeStr = null;
		if (date != null) {
			formatTimeStr = sdf.format(date);
		}
		return formatTimeStr;
	}
	
	
	
	/**
	 * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
	 * @param date  : 时间点
	 * @return
	 */
	public static String getCron(java.util.Date  date){
		String dateFormat="ss mm HH dd MM ? yyyy";
		return formatDateByPattern(date, dateFormat);
	}
	
	public static void main(String[] args) {
		System.err.println("格式化后："+getCron(new Date()));
	}
	
	
}
