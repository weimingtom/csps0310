package com.edot.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.edot.util.MD5Utils;

/**
 * 报文校验
 * Created by tony on 16/1/23.
 */
public class ValidFilter implements Filter {

    private static final String KEY = "123456";
    private static final String VALID_NAME = "valid";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String queryString;
            String validString = request.getParameter(VALID_NAME);
            if (validString == null || validString.length() == 0) {
                throw new ServletException("invalid data");
            }
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                queryString = request.getQueryString();
                queryString = queryString.replace(VALID_NAME + "=" + validString, "");
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                Enumeration enumeration = request.getParameterNames();
                List<String> params = new ArrayList<String>();
                while (enumeration.hasMoreElements()) {
                    String key = (String) enumeration.nextElement();
                    if (! key.equals(VALID_NAME)) {
                        params.add(key);
                    }
                }
                Collections.sort(params);
                queryString = "";
                for (String param : params) {
                    queryString += param + "=" + request.getParameter(param) + "&";
                }
            } else {
                throw new ServletException("only support request method: get/post");
            }
            if (queryString.endsWith("&")) {
                queryString = queryString.substring(0, queryString.length() - 1);
            }
            String md5Str = MD5Utils.MD5(queryString + KEY);
            if (! md5Str.equalsIgnoreCase(request.getParameter(VALID_NAME))) {
                throw new ServletException("invalid data");
            }
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
    }

    @Override
    public void destroy() {

    }
}
