package com.ohgiraffers.realtime.section02.longpolling;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LongPollingNotificationService {

    private final Map<String, DeferredResult<String>> deferredResults;

    public void sendNotification(String clientId, String message) {
        DeferredResult<String> result = deferredResults.get(clientId);
        if (result != null) {
            result.setResult("새 알림: " + message);
            deferredResults.remove(clientId);
        }
    }
}
