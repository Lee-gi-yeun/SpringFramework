package com.ohgiraffers.springsecurity.auth.service;

import com.ohgiraffers.springsecurity.auth.dto.LoginRequest;
import com.ohgiraffers.springsecurity.auth.dto.TokenResponse;
import com.ohgiraffers.springsecurity.auth.entity.RefreshToken;
import com.ohgiraffers.springsecurity.auth.repository.RefreshTokenRepository;
import com.ohgiraffers.springsecurity.command.entity.User;
import com.ohgiraffers.springsecurity.command.repository.UserRepository;
import com.ohgiraffers.springsecurity.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호");
        }

        // 로그인 성공 시 token 발급
        String accessToken = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUsername(), user.getRole().name());;

        // refreshToken은 서버측에서 관리 되어야 하는 데이터고 성능 상 추천 되는 환경은 Redis
        // RDBMS에 저장해서 관리하는 코드로 작성
        RefreshToken tokenEntity = RefreshToken.builder()
                .username(user.getUsername())
                .token(refreshToken)
                .expiryDate(new Date(System.currentTimeMillis() + jwtTokenProvider.getRefreshExpiration()))
                .build();

        refreshTokenRepository.save(tokenEntity);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }
}
