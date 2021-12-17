package com.bond.springcloud.exception;


/**
 * @author Stephen
 * */
public class ApiException extends FastCodeException {

    public ApiException(String msg) {
        super(msg);
    }
}
