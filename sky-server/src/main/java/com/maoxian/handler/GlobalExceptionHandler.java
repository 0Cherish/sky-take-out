package com.maoxian.handler;

import com.maoxian.constant.MessageConstant;
import com.maoxian.exception.BaseException;
import com.maoxian.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author Lin
 * @date 2023/12/31 13:52
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param e 异常
     * @return 响应
     */
    @ExceptionHandler(BaseException.class)
    public Result<String> baseExceptionHandler(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> sqlExceptionHandler(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        if (message.contains("Duplicate entry")){
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username + MessageConstant.ALREADY_EXISTS;
            return Result.error(msg);
        } else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }
}
