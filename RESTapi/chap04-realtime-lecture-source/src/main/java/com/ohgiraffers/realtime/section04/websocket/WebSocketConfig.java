package com.ohgiraffers.realtime.section04.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
// WebSocket 서버 설정과 관련된 정보를 제공
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/ws-chat").setAllowedOrigins("*");
    }
}
