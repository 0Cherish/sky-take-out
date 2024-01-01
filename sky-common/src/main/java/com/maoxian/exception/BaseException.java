package com.maoxian.exception;

/**
 * 业务异常
 *
 * @author Lin
 * @date 2023/12/31 12:44
 */
public class BaseException extends RuntimeException {
    public BaseException() {

    }

    public BaseException(String msg) {
        super(msg);
    }
}
