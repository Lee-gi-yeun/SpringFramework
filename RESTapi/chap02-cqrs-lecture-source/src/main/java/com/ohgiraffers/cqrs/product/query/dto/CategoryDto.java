package com.ohgiraffers.cqrs.product.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    private Long categoryCode;
    private String categoryName;
}
