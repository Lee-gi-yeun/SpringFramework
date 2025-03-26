package com.ohgiraffers.springmybatis.section01.factorybean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.SqlSessionTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// 단위 테스트
// Mockito 를 활용하여 의존성을 모킹(Mocking)한 후 MenuService의 순수 비즈니스 로직을 검증
@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    // @Mock : 모의 객체로 생성
    @Mock
    private SqlSessionTemplate sqlSession;  // 실제 DB 연결 없이 메소드 호출 처리 가능

    @Mock
    private MenuMapper menuMapper;  // Mybatis Mapper 구현체 없이 메소드 호출 가능

    // @InjectMocks : 모의 객체를 MenuService에 주입하여 내부 의존성이 대체 됨
    @InjectMocks
    private MenuService menuService;

    @BeforeEach
    public void setUp(){
        // sqlSession.getMapper(MenuMapper.class) 호출 시에 모의 객체 menuMapper를 반환하도록 설정
        when(sqlSession.getMapper(MenuMapper.class)).thenReturn(menuMapper);
    }

    // 1. 주문 가능 상태 "Y"를 전달하는 테스트 시나리오
    @Test
    public void testFindAllMenuByOrderableStatus_Orderable(){
    }

    // 2. 주문 가능 상태 "N"을 전달하는 테스트 시나리오
    @Test
    public void testFindAllMenuByOrderableStatus_NotOrderable(){
    }
}