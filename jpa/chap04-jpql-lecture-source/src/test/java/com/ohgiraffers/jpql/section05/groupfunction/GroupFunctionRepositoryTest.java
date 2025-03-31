package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupFunctionRepositoryTest {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 해당하는 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        int categoryCode = 4;
        Long menuCount = groupFunctionRepository.countMenuOfCategory(categoryCode);
        assertTrue(menuCount >= 0);
    }

    // COUNT 외의 그룹 함수의 경우 결과 행이 없을 때 null 값이 반환 되므로
    // 기본 자료형으로 다룰 경우 문제가 생긴다. Long, or Double 등의 Wrapper 타입으로 취급하도록 한다
    @DisplayName("특정 카테고리에 해당하는 메뉴 가격의 합 조회")
    @Test
    void testSumMenuPriceOfCategory() {
        int categoryCode = 777;
        assertDoesNotThrow(
                () -> {
                    Long sumMenuPrice = groupFunctionRepository.sumMenuPriceOfCategory(categoryCode);
                    System.out.println("sumMenuPrice=" + sumMenuPrice);
                }
        );
    }

    @DisplayName("Group By, Having 절 테스트")
    @Test
    void testSelectByGroupByHaving(){
        long minPrice = 50000L;
        List<Object[]> sumPriceCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);
        assertNotNull(sumPriceCategoryList);
        sumPriceCategoryList.forEach(
                row -> {
                    for (Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }


}