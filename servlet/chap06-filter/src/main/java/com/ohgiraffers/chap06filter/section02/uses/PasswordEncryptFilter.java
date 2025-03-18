package com.ohgiraffers.chap06filter.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(value = "/member/*")
public class PasswordEncryptFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Member와 관련 된 기능은 해당 필터를 거치게 되고 ServletRequest를 감사는 Wrapper
        // 객체로 변경하여 Request 객체를 전달 받게 된다
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
