package com.bond.springcloud.controller;

import com.bond.springcloud.model.ApiResult;
import com.bond.springcloud.model.IError;

/**
 * @Author: Stephen
 * @date: 2021-12-17 12:41
 */
public class CommonResult {
    protected <T> ApiResult<T> success(T data) {
        return ApiResult.success(data);
    }

    protected <T> ApiResult<T> success(String msg, T data) {
        return ApiResult.success(msg, data);
    }

    protected <T> ApiResult<T> failed(String msg) {
        return ApiResult.failed(msg);
    }

    protected <T> ApiResult<T> failed(IError errorCode) {
        return ApiResult.failed(errorCode);
    }
}
