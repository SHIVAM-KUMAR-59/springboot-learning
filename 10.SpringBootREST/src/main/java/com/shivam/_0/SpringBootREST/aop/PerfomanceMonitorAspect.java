package com.shivam._0.SpringBootREST.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfomanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerfomanceMonitorAspect.class);

    // Around is before and after the execution of the method
    @Around("execution(* com.shivam._0.SpringBootREST.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed(); // Let the method proceed as usual
        long end = System.currentTimeMillis();

        LOGGER.info("Time taken by " + proceedingJoinPoint.getSignature().getName() + " is: " + (end - start) + "ms");

        return obj;
    }

}
