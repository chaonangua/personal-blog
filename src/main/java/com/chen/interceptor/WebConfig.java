package com.chen.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 和LoginInterceptor配合使用,过滤所有关于(除/admin和/admin/login以外admin的url请求
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")//过滤
                .excludePathPatterns("/admin")//排除
                .excludePathPatterns("/admin/login");
    }
}
