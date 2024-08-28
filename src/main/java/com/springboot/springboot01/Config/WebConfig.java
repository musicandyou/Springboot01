package com.springboot.springboot01.Config;

import com.springboot.springboot01.Interceptor.LoginCheckInterceptor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 韩先楚
 */
@Configuration //配置类
public class WebConfig implements WebMvcConfigurer {
   @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new LoginCheckInterceptor())
              .addPathPatterns("/**").
              excludePathPatterns("/login","/Html/**");
    }
}
