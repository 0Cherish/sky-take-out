package com.maoxian.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS相关配置
 * @author Lin
 * @date 2024/1/3 12:31
 */
@Component
@ConfigurationProperties(prefix = "sky.alioos")
@Data
public class AliOssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
