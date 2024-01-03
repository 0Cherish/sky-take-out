package com.maoxian.annotation;

import com.maoxian.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标识某个方法需要进行自动填充
 *
 * @author Lin
 * @date 2024/1/3 11:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 数据库操作类型 insert update
    OperationType value();
}
