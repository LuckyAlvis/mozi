package com.dai.mozi.admin.common;

import lombok.Data;

@Data
public final class CommonResult<T> {
    private int status = 1;

    private String Code = "";

    private String Msg = "";

    private T data;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this.data = data;
    }
}
