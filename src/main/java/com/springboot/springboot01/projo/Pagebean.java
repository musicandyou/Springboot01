package com.springboot.springboot01.projo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 韩先楚
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagebean {
    private long total;
    private List<Emp> emp;
}
