package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    // DTO와 Entity의 분리
    // DTO(Data Transfer Object)는 프레젠테이션 계층과의 데이터 교환을 위한 객체로,
    // 도메인 로직을 담고 있는 Entity와 분리하여 사용함으로써 보안, 성능, 유지보수 측면의 이점을 얻을 수 있다.
    // 1. 보안 : 민감 데이터/과도 데이터 노출 방치, 과도한 바인딩 공격 방지
    public MenuDTO findMenuByMenuCode(int menuCode) {
        // 해당 코드로 겁색했을때 null이면 throw 발생
        Menu menu = menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);

        return null;
    }
}
