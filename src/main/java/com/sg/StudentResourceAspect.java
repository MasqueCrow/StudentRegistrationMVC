package com.sg;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sg.controller.StudentResource;

@Aspect
@Component
public class StudentResourceAspect {
	
	private final Logger LOG = LoggerFactory.getLogger(StudentResource.class);
	
	@Pointcut(value = "execution(* com.sg.controller.StudentResource.*(..))")
	public void methodLog() {
		this.LOG.info("Inside StudentResourceAspect methodLog method");
	}
	
	@Around(value="methodLog()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		Object ret = null;
		
		try {
			this.LOG.info("Entered method: " + pjp.getSignature().getName());
			ret = pjp.proceed();
			this.LOG.info("Exited method: " + pjp.getSignature().getName());
		} //try
		catch (Throwable e) {
			this.LOG.info("Exception in around advice");
			throw e;
		} //catch
		return ret;
	} //logAround
	
}
