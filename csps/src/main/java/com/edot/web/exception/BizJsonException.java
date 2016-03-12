package com.edot.web.exception;

/**
 * 业务异常类
 * Created by tony on 16/1/24.
 */
public class BizJsonException extends Exception {

    private String message;
    private String code;
    private Object data;

    public BizJsonException(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
