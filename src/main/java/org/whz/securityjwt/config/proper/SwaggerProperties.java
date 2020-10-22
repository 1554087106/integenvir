package org.whz.securityjwt.config.proper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger配置信息读取类
 */
@Data
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    // 是否开启swagger 生产环境一般关闭
    private Boolean enable;
    // 项目应用名
    private String applicationName;
    // 项目版本信息
    private String applicationVersion;
    // 项目描述信息
    private String applicationDescription;
    // 项目接口信息
    private String tryHost;

}