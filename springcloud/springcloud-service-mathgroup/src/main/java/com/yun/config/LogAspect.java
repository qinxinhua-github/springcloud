package com.yun.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * aop实现
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.yun.controller.MathController.getMathTeacher())")
    public void LogAspect(){}

    /**
     * 之前执行
     * @param joinPoint
     */
    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("doBefore");
    }

    /**
     * 之后执行
     * @param joinPoint
     */
    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    /**
     * 在方法执行后返回一个结果后执行
     * @param joinPoint
     */
    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("doAfterReturning");
    }

    /**
     * 在方法执行过程中抛出异常的时候执行
     * @param joinPoint
     */
    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){
        System.out.println("deAfterThrowing");
    }

    /**
     * 环绕通知，就是可以在执行前后都使用
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        return joinPoint.proceed();
    }
}
