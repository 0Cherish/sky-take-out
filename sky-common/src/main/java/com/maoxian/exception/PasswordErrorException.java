package com.maoxian.exception;

/**
 * 密码错误异常
 *
 * @author Lin
 * @date 2023/12/31 12:50
 */
public class PasswordErrorException extends BaseException {
    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }
}
