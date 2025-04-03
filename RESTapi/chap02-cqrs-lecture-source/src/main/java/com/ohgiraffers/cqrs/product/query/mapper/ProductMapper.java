package com.ohgiraffers.cqrs.product.query.mapper;

import com.ohgiraffers.cqrs.product.query.dto.response.ProductDto;
import com.ohgiraffers.cqrs.product.query.dto.request.ProductSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 상품 코드로 상품 하나 조회
    ProductDto selectProductByCode(Long productCode);

    // 검색/페이징 조건을 전달 받아 목록 조회
    List<ProductDto> selectProducts(ProductSearchRequest productSearchRequest);

    long countProducts(ProductSearchRequest productSearchRequest);
}
