package com.ohgiraffers.springdatajpa.menu.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO() {

    }
}
