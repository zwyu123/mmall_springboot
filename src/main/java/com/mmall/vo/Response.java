package com.mmall.vo;

import lombok.*;

@Getter
@Setter
@Builder
public class Response {
    private final String reslut = "OK";
    private String message;
}
