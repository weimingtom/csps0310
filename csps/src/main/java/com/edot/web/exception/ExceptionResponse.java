package com.edot.web.exception;

/**
 * 未知异常返回报文
 * Created by tony on 16/2/4.
 */
public class ExceptionResponse {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
