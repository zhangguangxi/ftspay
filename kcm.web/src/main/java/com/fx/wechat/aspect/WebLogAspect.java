package com.fx.wechat.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by JONES on 2017/12/27.
 */

@Slf4j
@Aspect
@Component
public class WebLogAspect {
    @Pointcut("execution(public * com.fx.wechat.controller..*.*(..))")
    public void webLog(){}

    /**
     * 入参日志
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求url : " + request.getRequestURL().toString());
        log.info("类名class_method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("入参 : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 返回日志
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret" , pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        log.info("返回结果 : " + ret);
        log.info(System.currentTimeMillis()+"");
    }
}
