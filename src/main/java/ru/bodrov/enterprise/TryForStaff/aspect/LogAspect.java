package ru.bodrov.enterprise.TryForStaff.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class LogAspect {

    private Logger log = Logger.getLogger(getClass().getName());

    @Pointcut("execution(*ru.bodrov.enterprise.*.*(..)")
    private void getActionName(){

    }

    @Before("getActionName()")
    public void logBefore(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + "before...");
    }

    @After("getActionName()")
    public void logAfter(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + "after...");
    }


}
