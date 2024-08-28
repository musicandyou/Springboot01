package com.springboot.springboot01.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 韩先楚
 */
@Controller
public class TextController {


    @RequestMapping("/aaa")
    public String aaa(){
        return "forward:/Html/Emp.html";
    }
}
