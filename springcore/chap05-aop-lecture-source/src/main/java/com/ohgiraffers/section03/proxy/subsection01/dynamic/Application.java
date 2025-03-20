package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        // 1. JDK Dynamic Proxy 방식
        // Target Object 타입이 반드시 interface 여야 한다
        Student student = new OhgiraffersStudent();
        Handler handler = new Handler(student);

        Student proxy = (Student) Proxy.newProxyInstance(
                Student.class.getClassLoader(), new Class[] {Student.class}, handler);
        proxy.study(16);
    }
}
