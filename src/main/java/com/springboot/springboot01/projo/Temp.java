package com.springboot.springboot01.projo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 韩先楚
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temp {
private Integer id;
private String name;
@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
@JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
private Date time;
}
