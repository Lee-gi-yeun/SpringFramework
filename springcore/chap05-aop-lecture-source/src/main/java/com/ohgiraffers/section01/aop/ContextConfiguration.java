package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// proxyTargetClass = true : Proxy 객체 생성의 방식으로 CGLib 방식을 사용
// target object class 인 경우에도 proxy 객체 생성 가능
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {
}