package com.ohgiraffers.realtime.section01.polling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polling")
public class PollingController {

    // n초마다 새로운 알림이 있는지 확인
    @GetMapping("/notifications")
    public ResponseEntity<String> getNotification() {
        // 랜덤 알림 발생 여부
        boolean hasNotification = Math.random() < 0.3;
        if (hasNotification) {
            return ResponseEntity.ok("새로운 알림이 도착했습니다!");
        } else {
            return ResponseEntity.ok("알림 없음");
        }
    }
}
