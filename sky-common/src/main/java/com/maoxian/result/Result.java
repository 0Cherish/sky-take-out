package com.maoxian.result;

import lombok.Data;

/**
 * 后端返回统一结果
 *
 * @author Lin
 * @date 2023/12/31 12:20
 */
@Data
public class Result<T> {
    /**
     * 编码 1:成功 其他:失败
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
