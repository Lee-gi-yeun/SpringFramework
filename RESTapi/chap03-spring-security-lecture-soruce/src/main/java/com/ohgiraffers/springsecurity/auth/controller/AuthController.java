package com.ohgiraffers.springsecurity.auth.controller;

import com.ohgiraffers.springsecurity.auth.dto.LoginRequest;
import com.ohgiraffers.springsecurity.auth.dto.TokenResponse;
import com.ohgiraffers.springsecurity.auth.service.AuthService;
import com.ohgiraffers.springsecurity.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest request){
        TokenResponse token = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success(token));
    }
}
