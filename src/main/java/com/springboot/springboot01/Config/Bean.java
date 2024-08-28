package com.springboot.springboot01.Config;

import com.springboot.springboot01.projo.Hello;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Configuration;

/**
 * @author 韩先楚
 */
@Configuration
public class Bean {

    @org.springframework.context.annotation.Bean()
    public Hello SayBean() {
        return new Hello();
    }

    @org.springframework.context.annotation.Bean()
    public SAXReader SAXReader()
    {
        return new SAXReader();
    }

//    @org.springframework.context.annotation.Bean
//    public HelloWorld helloWorld()
//    {
//        return new HelloWorld();
//    }

}
