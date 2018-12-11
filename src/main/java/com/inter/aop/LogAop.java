package com.inter.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inter.annotation.Log;
import com.inter.exception.CustomException;
import com.inter.mapper.log.SysLogMapper;
import com.inter.pojo.log.SysLog;
import com.inter.pojo.system.User;

@Component
@Aspect
public class LogAop {

	
	@Autowired
	SysLogMapper sysLogMapper; //自动装配一个dao，为了完成日志存储

	//定义切点，controller下，所有层级，所有类所有方法
	@Pointcut("execution(* com.inter.controller..*.*(..))")
	public void point() {
	}

	@Around("point()")
	public Object ar(ProceedingJoinPoint pjp) throws Throwable {
		
		Object object = null;

		SysLog syslog = new SysLog(); // 日志实体

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user"); //认证成功对象（前提是要在登录的controller中，将认证对象放到session）

		//以下操作获得当前拦截的方法
		Signature sig = pjp.getSignature();
		
		MethodSignature msig = null;
		
		if (!(sig instanceof MethodSignature)) throw new IllegalArgumentException("该注解只能用于方法");
		
		msig = (MethodSignature) sig;
		
		Object target = pjp.getTarget();
		
		Method currentMethod = null;
		try {
			currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}

		
		//判断当前操作对象是否为空
		if (currentMethod != null) {
			// 判断是否包含自定义的注解，说明一下这里的Log就是我自己自定义的注解
			if (currentMethod.isAnnotationPresent(Log.class)) {

				Log systemlog = currentMethod.getAnnotation(Log.class);//根据当前方法，获得Log注解的实例

				syslog.setDate(new Date());//设置执行时间
				
				syslog.setUrl(request.getRequestURL().toString());

				syslog.setModel(systemlog.operationType()); //从方法上的注解中获得操作类型

				syslog.setMethod(systemlog.operationName());//从方法上的注解中获得操作方法

				syslog.setSource(systemlog.operationSource());//从方法上的注解获得操作在哪个端
				//设置操作用户时要注意，比如登录方法，我们还没有经过认证，所以session当前用户对象是空的
				//如果为空，我们会给操作用户起名为：未注册用户
				if (user != null) syslog.setNickName(user.getNickName()); else syslog.setNickName("未注册用户"); 

				//获得当前请求用户的IP地址
				//String ip = CusAccessObjectUtil.getIpAddress(request);
				
				//获得客户端ip地址，测试中获得可能是ipv6，真实部署后会获得真实ip
				String ip = request.getRemoteAddr();
				syslog.setIp(ip);
				
				try {
					//拦截的方法开始执行
					object = pjp.proceed();
					//拦截方法执行后，成功则存贮执行成功
					syslog.setIsOk("执行成功");
					// 保存进数据库
					sysLogMapper.insertSelective(syslog);
					return object;
				} catch (Throwable e) {
					e.printStackTrace();
					//执行失败
					syslog.setIsOk("执行失败");
					//syslog.setMessage(e.getMessage().substring(0, e.getMessage().indexOf(":")));
					//保存禁数据库
					sysLogMapper.insertSelective(syslog);
					
					if(e instanceof CustomException) {
						throw new CustomException(e.getMessage());
					}else {
						throw new Exception();
					}
				}
			} else {
				// 没有包含Log注解，不在我们记录范围内
				return pjp.proceed();
			}
		} else {
			//拦截方法对象为空，直接跳过
			return pjp.proceed();
		}
	}
}


