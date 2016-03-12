package com.edot.support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * request中的输入流只能获取一次，针对这个限制，封闭一层后就可方便在任何地方获取输入流
 * Created by tony on 16/2/2.
 */
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest) {
            // request中的输入流只能获取一次，针对这个限制，封闭一层后就可方便在任何地方获取输入流
            EdotRequestWrapper requestWrapper = new EdotRequestWrapper((HttpServletRequest) servletRequest);
            filterChain.doFilter(requestWrapper, servletResponse);
        } else {
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");
        }
    }

    @Override
    public void destroy() {

    }
}
