package com.monk.sbbook.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截静态资源请求：
 * resources/static的资源是开放的，能直接访问，存在风险，需拦截
 * 把static/的url替换成sc/
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("sc/**").addResourceLocations("classpath:/static/");
    }

}
