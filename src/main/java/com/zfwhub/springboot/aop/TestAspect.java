package com.zfwhub.springboot.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class TestAspect {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Before("execution(* com.zfwhub.springboot.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info(" Check before-------------------------------------------------------- ");
        logger.info(" Allowed execution for {}", "");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
    

}
