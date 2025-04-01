package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.dto.MenuProjection;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // 메뉴 코드를 기준으로 내림차순 정렬한 DTO 프로젝션 반환 메소드
    List<MenuProjection> findAllByOrderByMenuCodeDesc();

}
