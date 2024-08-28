package com.springboot.springboot01.Interceptor;

import com.springboot.springboot01.projo.Jwt;
import com.springboot.springboot01.projo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.util.StringUtil;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 韩先楚
 */
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override  //目标资源运行前运行,放行为true 不放行返回false;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer url = request.getRequestURL();
        System.out.println("请求的url是：" + url.toString());
//        System.out.println("拦截成功");
        //判断请求是否已经登入过了 即发过来的请求有没有JWT令牌 判断其令牌有没有错
        //1.获取获取请求中的url
//        String url = request.getRequestURL().toString();
//        System.out.println(url);
        //2.判断URL里面是否有登录路径 即判断是不是应该登录请求
        // 如果是即放行请求 后面的逻辑不在运行 因为返回了
        // 也可以在配置类中创建拦截器时指定不拦截那个请求
//        if (url.contains("/login"))
//            return true;

        //3.获取请求头中的令牌("token") 没有令牌为null
//        String Jwt = request.getHeader("token");

        // 3.定义Jwt失败的响应体中的JSON格式字符串
        //手动转换 对象转为JSON
        //  JSONObject 对象的用于将对象转为一个JSON格式的字符串
        //其put方法往json格式字符串里加入数据
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",0);
//        jsonObject.put("msg","error");
//        jsonObject.put("msg","No-login");

        //4.判断Jwt令牌是否存在 如果不存在 就返回错误结果
//        if (!StringUtils.hasLength(Jwt))
//        {
//            System.out.println("请求中的令牌不存在");
////            Result error = Result.error("No-login");
//            System.out.println(jsonObject.toString());
//            //往响应体中加入json数据
//            response.getWriter().write(jsonObject.toString());
//            return false;
//        }

        //如果检验Jwt有错误就不放行
//        try {
//            com.springboot.springboot01.projo.Jwt.ParseJwt(Jwt);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(jsonObject.toString());
//            //往响应中加入json数据
//            response.getWriter().write(jsonObject.toString());
//            return false;
//        }

        //如果前面的验证全部通过 说明已经登录过了 就放行
        return true;

    }

    @Override //Controller 层方法运行完运行完运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("controller 方法调用完成");
    }

    @Override //视图运行完毕后运行 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("视图渲染完成");
    }
}
