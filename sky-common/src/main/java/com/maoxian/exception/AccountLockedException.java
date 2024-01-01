package com.maoxian.exception;

/**
 * 账号被锁定异常
 *
 * @author Lin
 * @date 2023/12/31 12:56
 */
public class AccountLockedException extends BaseException {
    public AccountLockedException() {
    }

    public AccountLockedException(String msg) {
        super(msg);
    }
}
