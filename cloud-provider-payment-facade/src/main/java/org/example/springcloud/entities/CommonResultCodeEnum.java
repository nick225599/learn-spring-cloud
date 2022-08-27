package org.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum CommonResultCodeEnum {
    SUCCESS("000000", "SUCCESS"),
    PROCESSING("010001", "PROCESSING"),
    NOT_FOUND("01002", "NOT_FOUND"),
    FAIL("010099", "FAIL"),
    ;

    private final String code;
    private final String message;
}
