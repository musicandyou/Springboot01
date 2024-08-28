package com.springboot.springboot01.Controller;

import com.springboot.springboot01.Service.DeptService;
import com.springboot.springboot01.projo.Emp;
import com.springboot.springboot01.projo.Jwt;
import com.springboot.springboot01.projo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 韩先楚
 */
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private DeptService deptService;

    @PostMapping ("/login")
    public Result Login(Emp emps)
    {
        Emp login = deptService.Login(emps);
      if (login!=null)
      {
//          Map<String,Object> claims=new HashMap();
//          claims.put("id",login.getId());
//          claims.put("name",login.getName());
//          claims.put("username",login.getUsername());
//          String jwt = Jwt.GetJwt(claims);
          return Result.success();
      }
        else
            return Result.error("用户名或密码不正确");
    }
}
