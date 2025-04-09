package com.ohgiraffers.orderservice.command.client;

import com.ohgiraffers.orderservice.common.ApiResponse;
import com.ohgiraffers.orderservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8000", configuration = FeignClientConfig.class)
public interface UserClient {

    // User Service에서 사용자 상태나 간단한 정보를 조회하는 API
    @GetMapping("/api/v1/user-service/users/{userId}/grade")
    ApiResponse<String> getUserGrade(@PathVariable("userId") Long userId);
}
