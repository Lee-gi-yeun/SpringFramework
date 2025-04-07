package com.ohgiraffers.realtime.section03.sse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/sse")
@RequiredArgsConstructor
public class SseConnectController {

    private final Map<String, SseEmitter> sseEmitters;

    /* 클라이언트가 연결 요청할 때 호출되는 엔드포인트
     * 클라이언트는 고유 ID를 가지고 있어야 함 (ex. 사용자 ID) */
    @GetMapping(value = "/connect/{clientId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter connect(@PathVariable String clientId) {
        SseEmitter emitter = new SseEmitter(60 * 1000L); // 1분 유지
        sseEmitters.put(clientId, emitter);

        emitter.onCompletion(() -> sseEmitters.remove(clientId));
        emitter.onTimeout(() -> sseEmitters.remove(clientId));
        emitter.onError(e -> sseEmitters.remove(clientId));

        try {
            emitter.send(SseEmitter.event().name("connect").data("연결 성공"));
        } catch (IOException e) {
            emitter.completeWithError(e);
        }

        return emitter;
    }
}
