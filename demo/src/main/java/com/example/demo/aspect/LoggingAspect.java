package com.example.demo.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@Before("execution(* com.example.demo.MyController.loginUser(..))")
	public void before() {
		LOGGER.info("going inside login method");
	}

	@AfterReturning(pointcut = "execution(* com.example.demo.MyController.loginUser(..))", returning = "val")
	public void afterExecution(JoinPoint j, Object val) {
		LOGGER.info("login method is completed without any exception");
		LOGGER.info(val);
		LOGGER.info(j.getSignature());
	}

	@After("execution(* com.example.demo.MyController.loginUser(..))")
	public void after() {
		LOGGER.info("login method is completed");
	}

	@AfterThrowing(pointcut = "execution(* com.example.demo.MyController.loginUser(..))", throwing = "exception")
	public void afterthrowing(ArithmeticException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}

	@Around("execution(* com.example.demo.MyController.loginUser(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LOGGER.info("before proceeding part of around advice");
		Object returnedData = proceedingJoinPoint.proceed();
		LOGGER.info("After proceeding part of around advice");
		return returnedData;

	}
}