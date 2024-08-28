package com.springboot.springboot01.projo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 韩先楚
 */
//记录增删改操作的信息表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id;
    private Integer operateUser;
    private LocalDateTime operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private long costTime;
}
