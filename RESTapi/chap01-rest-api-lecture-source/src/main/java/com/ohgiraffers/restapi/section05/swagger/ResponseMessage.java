package com.ohgiraffers.restapi.section05.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMessage {

    private int httpStatus;
    private String message;
    private Map<String, Object> result;

}
