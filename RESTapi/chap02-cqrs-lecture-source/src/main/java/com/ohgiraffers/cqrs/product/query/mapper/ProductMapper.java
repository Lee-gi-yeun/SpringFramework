package com.ohgiraffers.cqrs.product.query.mapper;

import com.ohgiraffers.cqrs.product.query.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    ProductDto selectProductByCode(Long productCode);
}
