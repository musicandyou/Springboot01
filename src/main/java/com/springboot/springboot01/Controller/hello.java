package com.springboot.springboot01.Controller;

import com.springboot.springboot01.Dao.Text02;
import com.springboot.springboot01.Service.Text01;
import com.springboot.springboot01.projo.Result;
import com.springboot.springboot01.projo.Temp;
import com.springboot.springboot01.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 韩先楚
 */
@RestController
public class hello {
    @Autowired
     Text01 text01;

    @Autowired
    Text02 text02;

    @RequestMapping("/abc")
  public String lll( @RequestBody User user)
    {
        System.out.println(user.getName());
        System.out.println("abc");
        System.out.println("abc02");
        System.out.println("abc03");
        System.out.println("hot-fix");

//        System.out.println(age);
        return user.toString();

    }

    @RequestMapping("/Datatime")
    public Date dateTime( @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTime)
    {
        System.out.println(dateTime.toString());
        return dateTime;
    }

    @RequestMapping("/Path/{id}")
    public Result Path(@PathVariable Integer id, String name)
    {
        System.out.println(id+name);
        Result r=Result.success(id+name);
        System.out.println(r);
       text01.a2();
       text01.a1();
        return r;
    }

    @PostMapping ("/2014")
    public void my(@RequestBody Temp temp)
    {
      Integer a=   text02.In(temp);
        System.out.println(a);
    }

}
