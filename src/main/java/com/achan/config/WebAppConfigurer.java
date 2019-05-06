package com.achan.config;

import com.achan.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AChan
 * @title: WebAppConfigurer
 * @date 2019/5/6
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截的对象会进入这个类中进行判断
        InterceptorRegistration registration = registry.addInterceptor(new PermissionInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/home", "/login", "/view/**", "/register");
//        registration.excludePathPatterns("/","/login","/error","/static/**","/logout");

    }
}
