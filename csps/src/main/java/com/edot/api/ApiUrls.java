package com.edot.api;

/**
 * API请求地址
 * Created by tony on 16/2/3.
 */
public class ApiUrls {

    public static final String HOST = "http://localhost:8080";

    public static final String LOGIN = HOST + "/user/login";
    public static final String REGISTER = HOST + "/user/register";
    
    
    // for test
	public static final String HOST_API = HOST + "/csps-api";
    public static final String TEST_LIST = HOST_API + "/list";
    public static final String TEST_DETAIL = HOST_API + "/detail";
    public static final String TEST_EDIT = HOST_API + "/insert";
    public static final String TEST_DELETE = HOST_API + "/delete";
}
