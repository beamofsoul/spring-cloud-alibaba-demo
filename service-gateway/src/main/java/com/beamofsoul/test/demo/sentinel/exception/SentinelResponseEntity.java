package com.beamofsoul.test.demo.sentinel.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SentinelResponseEntity {

    private Integer code;
    private String message;
    private Object data;
}
