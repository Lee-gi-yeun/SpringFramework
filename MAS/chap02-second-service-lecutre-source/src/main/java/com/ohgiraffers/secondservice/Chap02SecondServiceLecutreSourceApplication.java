package com.ohgiraffers.secondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Chap02SecondServiceLecutreSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap02SecondServiceLecutreSourceApplication.class, args);
    }

}
