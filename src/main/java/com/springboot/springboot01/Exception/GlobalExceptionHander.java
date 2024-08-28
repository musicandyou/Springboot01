package com.springboot.springboot01.Exception;

import com.springboot.springboot01.projo.Result;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 韩先楚
 *
 */
//全局异常处理类
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHander {

    @ExceptionHandler(Exception.class)
    public Result ExceptionHander(Exception e)
    {
        log.info(e.getMessage());
        return Result.error("服务端出现错误");
    }
}
