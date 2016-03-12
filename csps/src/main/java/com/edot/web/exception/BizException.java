package com.edot.web.exception;

/**
 * 业务异常
 * Created by tony on 16/2/4.
 */
public class BizException extends Exception {

    private String code;
    private String message;
    private Object data;

    public BizException(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
