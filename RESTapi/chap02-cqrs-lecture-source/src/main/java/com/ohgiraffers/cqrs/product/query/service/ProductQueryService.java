package com.ohgiraffers.cqrs.product.query.service;

import com.ohgiraffers.cqrs.exception.BusinessException;
import com.ohgiraffers.cqrs.exception.ErrorCode;
import com.ohgiraffers.cqrs.product.query.dto.ProductDetailResponse;
import com.ohgiraffers.cqrs.product.query.dto.ProductDto;
import com.ohgiraffers.cqrs.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductMapper productMapper;

    // 상품 상세 조회
    @Transactional(readOnly = true)
    public ProductDetailResponse getProduct(Long productCode){

        ProductDto product = Optional.ofNullable(
                productMapper.selectProductByCode(productCode))
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        return null;
    }
}
