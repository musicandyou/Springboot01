package com.springboot.springboot01.aop;

import com.springboot.springboot01.Dao.Emp;
import com.springboot.springboot01.projo.Jwt;
import com.springboot.springboot01.projo.OperateLog;
import com.springboot.springboot01.projo.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author 韩先楚
 */
@Slf4j
@Component
@Aspect //aop类
public class TimeAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private Emp emp;
    //切点 用于将相同的切入点表达式提取出来,用于更好的管理
    @Pointcut("execution(* com.springboot.springboot01.Service.*.*(..))")
    private void pt(){};

    @Around("@annotation(com.springboot.springboot01.anno.OprateLog)")
    public Object operatelog(ProceedingJoinPoint joinPoint) throws Throwable {
             //运行目标方法
        long start = System.currentTimeMillis();
        Integer proceed = (Integer) joinPoint.proceed();
        long end = System.currentTimeMillis();
        //定义一个OperateLog类
        OperateLog log = new OperateLog();
        //获取操作人id 藏在Jwt令牌里面
//        String jwt = httpServletRequest.getHeader("token");
//        Claims claims = Jwt.ParseJwt(jwt);
//        Object id = claims.get("id");
        log.setOperateUser(1);
        //操作时间
        log.setOperateTime(LocalDateTime.now());
        //操作类名
        String name = joinPoint.getTarget().getClass().getName();
        log.setClassName(name);
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        log.setMethodName(methodName);
        //操作方法参数
        Object[] args = joinPoint.getArgs();
        log.setMethodParams(Arrays.toString(args));
        //操作方法返回值
        log.setReturnValue(proceed+"" );
        //操作耗时
        log.setCostTime((end-start));
        emp.operateLog(log);
        return proceed;
    }


//    @Around("pt()") //切入点表达式
//    public Object Time(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        //记录初始时间
//        long start = System.currentTimeMillis();
//        //获取目标对象的类名
//        String name = proceedingJoinPoint.getThis().getClass().getName();
//        log.info("目标对象的类名"+name);
//        //获取目标方法的方法名
//        String name1 = proceedingJoinPoint.getSignature().getDeclaringTypeName();
//        log.info("目标方法的方法名"+name1);
//        //获取目标方法的参数
//        Object[] args = proceedingJoinPoint.getArgs();
//        log.info("目标方法的参数"+ Arrays.toString(args));
//        //运行原始方法
//        Object proceed = proceedingJoinPoint.proceed();
//
//
//        //记录结束时间
//        long end = System.currentTimeMillis();
//        //输出程序运行时间和运行的包 接口 实现类 和其中的方法 proceedingJoinPoint.getSignature()
//        log.info(proceedingJoinPoint.getSignature()+"运行时间为"+(end-start));
//        //返回值
//        return proceed;
//    }
//
//    @Before("execution(* com.springboot.springboot01.Service.*.*(..))")
//    public void Before(JoinPoint joinPoint)
//    {
//        String name = joinPoint.getTarget().getClass().getName();
//        log.info("前置被执行");
//    }
//
//    @After("execution(* com.springboot.springboot01.Service.*.*(..))")
//    public void After()
//    {
//        log.info("后置被执行");
//    }


}
