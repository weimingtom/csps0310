package com.edot.support;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 日志记录
 * Created by tony on 15/3/28.
 */
@Component
@Aspect
public class LogAop {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("execution(* com.edot.controller.*..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void point() {}

    @Around("point()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录请求开始时间
        long time = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String queryString;
        // GET请求，直接获取请求参数
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            queryString = request.getQueryString();
        }
        // POST请求，从输入流中获取报文
        else {
            EdotRequestWrapper requestWrapper = new EdotRequestWrapper(request);
            queryString = requestWrapper.getBody();
        }
        logger.info("[REQUEST][" + joinPoint.getTarget().getClass().getSimpleName() + "-" + joinPoint.getSignature().getName() + "]-[" + queryString + "]");
        Object result = joinPoint.proceed();
        // 记录请求结束时间
        time = System.currentTimeMillis() - time;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmss"));
        logger.info("[RESPONSE][" + joinPoint.getTarget().getClass().getSimpleName() + "-" + joinPoint.getSignature().getName() + "][" + time + "]-[" + objectMapper.writeValueAsString(result) + "]");
        return result;
    }
}
