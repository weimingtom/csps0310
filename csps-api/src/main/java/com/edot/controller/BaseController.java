package com.edot.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edot.util.ExceptionUtils;
import com.edot.web.exception.BizException;
import com.edot.web.exception.BizExceptionResponse;
import com.edot.web.exception.ExceptionResponse;

/**
 * 控制基类
 * Created by tony on 16/1/24.
 */
public class BaseController {

    private static final int EXCEPTION_CODE = 520;

    private static final int BIZ_EXCEPTION_CODE = 210;

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({BizException.class})
    @ResponseBody
    public BizExceptionResponse handleBizException(BizException bizException, HttpServletResponse response) {
        BizExceptionResponse bizExceptionResponse = new BizExceptionResponse();
        bizExceptionResponse.setCode(bizException.getCode());
        bizExceptionResponse.setMessage(messageSource.getMessage(bizException.getCode(), null, null));
        bizExceptionResponse.setData(bizException.getData());
        response.setStatus(BIZ_EXCEPTION_CODE);
        return bizExceptionResponse;
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ExceptionResponse handleException(Exception exception, HttpServletResponse response) {
        logger.error(ExceptionUtils.getExceptionTrace(exception));
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode("server.error");
        exceptionResponse.setMessage(messageSource.getMessage("server.error", null, null));
        response.setStatus(EXCEPTION_CODE);
        return exceptionResponse;
    }
}
