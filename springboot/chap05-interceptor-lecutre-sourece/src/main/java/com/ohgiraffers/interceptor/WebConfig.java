package com.ohgiraffers.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StopwatchInterceptor stopwatchInterceptor;

    //@AutoWired
    public WebConfig(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor).addPathPatterns("/stopwatch");
    }
}
