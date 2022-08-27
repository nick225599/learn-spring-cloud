package org.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private String code;
    private String message;
    private CommonResultCodeEnum resultCodeEnum;
    private T data;

    public CommonResult(CommonResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum, null);
    }

    public CommonResult(CommonResultCodeEnum resultCodeEnum, T data) {
        this(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), resultCodeEnum, data);

    }
}
