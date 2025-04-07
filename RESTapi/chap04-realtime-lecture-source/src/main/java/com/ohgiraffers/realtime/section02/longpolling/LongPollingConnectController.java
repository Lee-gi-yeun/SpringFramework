package com.ohgiraffers.realtime.section02.longpolling;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

@RestController
@RequestMapping("/long-polling")
@RequiredArgsConstructor
public class LongPollingConnectController {

    private final Map<String, DeferredResult<String>> deferredResults;

    @GetMapping("/connect/{userId}")
    public DeferredResult<String> connect(@PathVariable String userId) {
        DeferredResult<String> result = new DeferredResult<>(10000L); // 10초 제한
        deferredResults.put(userId, result);

        result.onCompletion(() -> deferredResults.remove(userId));
        result.onTimeout(() -> {
            result.setResult("알림 없음 (타임아웃)");
            deferredResults.remove(userId);
        });

        return result;
    }
}