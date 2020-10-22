package org.whz.securityjwt.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.whz.securityjwt.config.proper.SwaggerProperties;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.lang.reflect.Field;
import java.util.*;

/**
 * swagger访问路径 http://localhost:8080/swagger-ui/index.html
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class Swagger3Config implements WebMvcConfigurer {
    private final SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        log.info("createRestApi -> swaggerProperties: {}", JSON.toJSONString(swaggerProperties));
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(swaggerProperties.getEnable())
                .apiInfo(apiInfo())
                .host(swaggerProperties.getTryHost())
                .select()
                // 扫描controller生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议
                .protocols(newHashSet("http", "https"))
                // 授权信息设置 必要的header token等认证信息
                .securitySchemes(securitySchemes())
                // 授权信息全局应用
                .securityContexts(securityContexts());
    }

    /**
     * API页面上半部分展示信息
     * @return
     */
    private ApiInfo apiInfo() {
        log.info("apiInfo -> swaggerProperties: {}", JSON.toJSONString(swaggerProperties));
        return new ApiInfoBuilder()
                // 文档标题
                .title(swaggerProperties.getApplicationName() + "SwaggerUI学习")
                .description(swaggerProperties.getApplicationDescription())
                .contact(new Contact("lighter", null, "123456@gmail.com"))
                .version("Application Version: " + swaggerProperties.getApplicationVersion() + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();

    }

    /**
     * 设置授权信息
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("BASE_TOKEN", "Bearer ", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     * @return
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                               .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                               .build()
        );
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if(ts.length > 0) {
            return Sets.newLinkedHashSet(Arrays.asList(ts));
        }
        return null;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        Field registrationsField = FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
        List<InterceptorRegistration> registrations = (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
        if(registrations != null) {
            for(InterceptorRegistration interceptorRegistration : registrations) {
                interceptorRegistration
                        .excludePathPatterns("/swagger**/**")
                        .excludePathPatterns("/webjars/**")
                        .excludePathPatterns("/v3/**")
                        .excludePathPatterns("/doc.html");
            }

        }

    }
}
