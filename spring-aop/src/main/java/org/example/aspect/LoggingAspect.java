package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * Перехват всех методов из SimpleService
     */
    @Pointcut("within(org.example.service.SimpleService)")
    public void pointcut() {}

    /**
     * Перехват выполнения public void testMethod()
     */
    @Pointcut("execution(public void testMethod())")
    public void pointcut2() {}

    /**
     * Что нужно сделать когда произошел перехват
     * @param joinPoint
     */
    @After("pointcut()")
    public void logInfoMethodCall(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.log(Level.INFO, "Аргументы метода " + List.of(args));
    }
    @Before("pointcut2()")
    public void logWarningMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.WARNING, "Название метода " + methodName);
    }

    @AfterReturning(pointcut = "execution(String org.example.service.SimpleService.*(..))", returning = "result")
    public void logAfterReeturning(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "возвращаемое значение " + result);
    }

    /**
     * Перехват методов, помеченных аннотацией с фиксированием времени исполнения
     * @param joinPoint перехваченный метод
     */
    @Around("@annotation(org.example.annotation.LogMethodInfo)")
    public Object logExecTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.log(Level.INFO, joinPoint.getSignature() + "выполнен за" + (end - start) + "ms");
        return proceed;
    }


}
