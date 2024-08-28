package com.springboot.springboot01.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author 韩先楚
 */
@WebFilter(urlPatterns = "/*")
public class Dempfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
//        System.out.println("filter对象初始化已经执行了");
    }

    @Override
    //每发送一个请求就拦截一次并调用其方法
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截了请求");
        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println(servletResponse.getBufferSize());
        //施放请求和响应
//        System.out.println("执行完毕");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("filter对象销毁已经执行了");
    }
}
