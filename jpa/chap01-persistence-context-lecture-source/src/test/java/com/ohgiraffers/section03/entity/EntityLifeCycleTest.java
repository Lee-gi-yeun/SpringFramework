package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EntityLifeCycleTest {

    private EntityLifeCycle entityLifeCycle;

    @BeforeEach
    void init(){
        entityLifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testTransient(int menuCode){
        // when
        Menu foundMenu = entityLifeCycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = entityLifeCycle.getManagerInstance();

        // then
        assertTrue(entityManager.contains(foundMenu));  // 영속성 컨텍스트에서 관리 되는 영속 상탱
        assertFalse(entityManager.contains(newMenu));   // 영속성 컨텍스트에서 관리 되지 않는 비영속 상태
    }

    @DisplayName("다른 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testManagedOtherEntityManager(int menuCode){
        // when
        Menu menu1 = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = entityLifeCycle.findMenuByMenuCode(menuCode);

        //then
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testManagedSameEntityManager(int menuCode){
        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);

        //then
        assertEquals(menu1, menu2);
    }

}