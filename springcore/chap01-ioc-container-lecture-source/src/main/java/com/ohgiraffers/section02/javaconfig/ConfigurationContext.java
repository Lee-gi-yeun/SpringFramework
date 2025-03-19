package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;

public class ConfigurationContext {

    // Bean 사용 시 name 속성을 생략하면 메소드 명이 bean의 이름이 된다
    @Bean(name = "member")
    public MemberDTO getMember(){
        return new MemberDTO(1,"user01","pass01", "유관순");
    }
}
