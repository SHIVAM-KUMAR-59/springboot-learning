package com.shivam._0.SpringBootREST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // Return type, fully qualified class name(including package), method name, arguments

    // Before the method call execution starts
    @Before("execution(* com.shivam._0.SpringBootREST.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method called " + joinPoint.getSignature().getName());
    }

    // After the method call has been executed
    @After("execution(* com.shivam._0.SpringBootREST.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method executed " + joinPoint.getSignature().getName());
    }

}
