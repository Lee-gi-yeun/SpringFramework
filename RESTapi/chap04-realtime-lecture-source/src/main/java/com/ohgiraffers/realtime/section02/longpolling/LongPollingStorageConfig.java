package com.ohgiraffers.realtime.section02.longpolling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class LongPollingStorageConfig {

    @Bean
    public Map<String, DeferredResult<String>> deferredResults() {
        return new ConcurrentHashMap<>();   // thread-safe
    }
}
