package com.maoxian.exception;

/**
 * @author Lin
 * @date 2024/1/2 9:03
 */
public class DeletionNotAllowedException extends BaseException{

    public DeletionNotAllowedException() {
    }

    public DeletionNotAllowedException(String msg) {
        super(msg);
    }
}
