package org.example.springcloud.entities;

import lombok.Data;

@Data
public class CommonResult<T> {
    private String code;
    private String message;
    private CommonResultCodeEnum resultCodeEnum;
    private T data;

    private CommonResult(String code,
                         String message,
                         CommonResultCodeEnum resultCodeEnum,
                         T data) {
        this.code = code;
        this.message = message;
        this.resultCodeEnum = resultCodeEnum;
        this.data = data;
    }

    public CommonResult(CommonResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum, null);
    }

    public CommonResult(CommonResultCodeEnum resultCodeEnum, T data) {
        this(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), resultCodeEnum, data);

    }
}
