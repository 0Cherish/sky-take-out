package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author Lin
 * @date 2023/12/31 11:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    /**
     * 微信用户唯一标识
     */
    private String openid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别 0:女 1:男
     */
    private String sex;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 注册时间
     */
    private LocalDateTime createTime;
}
