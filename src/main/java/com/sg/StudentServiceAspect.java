package com.sg;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sg.service.StudentService;


@Aspect
@Component
public class StudentServiceAspect {
	private final Logger LOG = LoggerFactory.getLogger(StudentService.class);
	
	@Pointcut(value = "execution(* com.sg.service.StudentService.*(..))")
	public void methodLog() {
		LOG.info("Inside StudentServiceAspect");
	}
	
	@Around(value="methodLog()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		Object ret = null;
		
		try {
			LOG.info("Class Name : {} Entered method: {}", pjp.getSignature().getDeclaringTypeName() ,pjp.getSignature().getName());
			long startTime = System.currentTimeMillis();
			ret = pjp.proceed();
			long endtime = System.currentTimeMillis();
			LOG.info("Time taken for Execution is : " + (endtime - startTime) +"ms");
			LOG.info("Exited method:{} ", pjp.getSignature().getName());
		} //try
		catch (Throwable e) {
			this.LOG.info("Exception in around advice");
			throw e;
		} //catch
		return ret;
	} //logAround
}
