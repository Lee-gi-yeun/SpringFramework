package com.ohgiraffers.chap06filter.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. POST 전송 시 한글 값 문자 셋 미설정으로 인한 한글 깨짐 현상 (Tomcat 9 이전)
        // 2. 비밀번호 암호화
        // 위의 두 가지 처리를 필터로 작성하여 다른 서블릿에서도 공통 적용 될 수 있도록 한다
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);
    }
}
