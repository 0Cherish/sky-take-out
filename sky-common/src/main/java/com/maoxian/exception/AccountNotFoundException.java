package com.maoxian.exception;

/**
 * 账号不存在异常
 *
 * @author Lin
 * @date 2023/12/31 12:43
 */
public class AccountNotFoundException extends BaseException {
    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
