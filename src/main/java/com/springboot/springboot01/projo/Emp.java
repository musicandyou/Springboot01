package com.springboot.springboot01.projo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 韩先楚
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String image;
    private Integer job;
//    @JsonFormat(pattern = "yy-MM-dd")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date entryDate;
    private Integer deptId;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date updateTime;
}
