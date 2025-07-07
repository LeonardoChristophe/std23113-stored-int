package com.examen.stored.endpoint;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StoredEndPointConf implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) new RequestLoggerConfigurer());
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/stored-int").setViewName("forward:/stored-int");
    }
}
