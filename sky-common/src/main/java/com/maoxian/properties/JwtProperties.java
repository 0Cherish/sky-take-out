package com.maoxian.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 生成jwt令牌相关配置
 *
 * @author Lin
 * @date 2023/12/31 11:51
 */
@Component
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {

    /**
     * 管理端员工-jwt签名密钥
     */
    private String adminSecretKey;
    /**
     * 管理端员工-jwt过期时间
     */
    private long adminTtl;
    /**
     * 管理端员工-令牌名称
     */
    private String adminTokenName;

    /**
     * 用户端微信用户-jwt签名密钥
     */
    private String userSecretKey;
    /**
     * 用户端微信用户-jwt过期时间
     */
    private long userTtl;
    /**
     * 用户端微信用户-令牌名称
     */
    private String userTokenName;
}
