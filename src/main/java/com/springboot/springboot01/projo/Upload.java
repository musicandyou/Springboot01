package com.springboot.springboot01.projo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 韩先楚
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Upload {
    private String name;
    private Integer age;
    private MultipartFile image;
}
