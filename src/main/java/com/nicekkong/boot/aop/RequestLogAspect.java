package com.nicekkong.boot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// https://jeong-pro.tistory.com/171
@Aspect
@Component
public class RequestLogAspect {

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(" execution(* com.nicekkong.boot..*.*(..))\n")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.debug("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    }

}
