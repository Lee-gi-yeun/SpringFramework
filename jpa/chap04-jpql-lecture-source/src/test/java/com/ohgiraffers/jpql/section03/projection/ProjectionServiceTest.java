package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectionServiceTest {

    @Autowired
    private ProjectionService projectionService;

    @DisplayName("엔터티 프로젝션 테스트")
    @Test
    public void testSingleEntityProjection() {
        List<Menu> menus = projectionService.singleEntityProjection();
        assertNotNull(menus);
        assertEquals("세상에서 제일 맛있는 유니콘 고기", menus.get(0).getMenuName());
    }

}