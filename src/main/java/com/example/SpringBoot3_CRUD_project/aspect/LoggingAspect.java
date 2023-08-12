package com.example.SpringBoot3_CRUD_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.SpringBoot3_CRUD_project.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.example.SpringBoot3_CRUD_project.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.example.SpringBoot3_CRUD_project.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>> in @Before: calling method: " + method);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("===>> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>> in @AfterReturning: from method: " + method);
        logger.info("===>> result: " + result);
    }

}
