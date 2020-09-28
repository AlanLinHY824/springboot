package com.powernode.springboot.config;

import com.powernode.springboot.myinterceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author AlanLin
 * @Description
 * @Date 2020/9/28
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePatterns={"/**/queryAllStudent"};
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(excludePatterns);
    }
}
