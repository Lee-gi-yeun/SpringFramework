package com.ohgiraffers.chap05cookiesessionlecturesource.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/cookie-redirect")
public class CoolieRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // redirect 처리 시 이전 req 정보는 존재하지 않으며 새로운 req 객체이므로 null 반환
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName + " lastName: " + lastName);

        // 저장 된 쿠키 값을 꺼내서 확인
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("firstName")) {
                firstName = cookie.getValue();
            } else if(cookie.getName().equals("lastName")){
                lastName = cookie.getValue();
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>your firstName is" + firstName +" and lastName is" + lastName + "</h1>");
        out.flush();
        out.close();
    }
}
