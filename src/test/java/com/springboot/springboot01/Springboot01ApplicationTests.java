package com.springboot.springboot01;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.springboot01.Config.Bean;
import com.springboot.springboot01.Controller.DeptController;
import com.springboot.springboot01.Dao.Emp;
import com.springboot.springboot01.Dao.Text02;
import com.springboot.springboot01.projo.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import jakarta.security.auth.message.callback.PrivateKeyCallback;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Request;
import org.apache.ibatis.annotations.Select;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.*;

@SpringBootTest
class Springboot01ApplicationTests {
  @Autowired
  Text02 text02;
@Autowired
User user;
  @Autowired
  private Emp emp;
    @Test
    void contextLoads() {

    }
//    @Select("select firstname from manage where firstname like concat(#{name},'%')")
//    public List<User> app01(String name);
    @Test
    public void ap()
    {
        List<User> list = text02.app01(null);
        for (User user : list)
        {
            System.out.println(user.getFirstname());
        }
    }
    List<Integer> list = new ArrayList<>();
   @Test
    public void  Dele()
   {
     for (String i : user.getHobby())
         System.out.println(i);

   }
    @Test
   public void Text02()
   {
       com.springboot.springboot01.projo.Emp emp1 = new com.springboot.springboot01.projo.Emp();
       emp1.setUsername("hxc");
       emp1.setPassword("1234");
       com.springboot.springboot01.projo.Emp login = emp.Login(emp1);
       System.out.println(login);
   }

//   生成一个JWt令牌
    @Test
    public void GetJwtText()
    {
         Map<String,Object> map = new HashMap();
         String s="you-boyfriend";
        byte[] hxc = s.getBytes(StandardCharsets.UTF_8);
        map.put("名字","韩先楚");
        map.put("性别","男");
        map.put("爱好","导");
        String Jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,hxc)
                //设置密钥和数字算法,用于数字签名计算 注意传入的要为一个字节数组
                .setClaims(map)
                //设置自定义数据
                .setSubject("JWT令牌")
                //设置jWT主题 通常是用户id或用户名
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 10000))
                //设置密钥使用时间日期
                .compact();
        System.out.println(Jwt);
    }
  //  eyJhbGciOiJIUzI1NiJ9.eyLlkI3lrZciOiLpn6nlhYjmpZoiLCJzdWIiOiJKV1Tku6TniYwiLCLniLHlpb0iOiLlr7wiLCJleHAiOjE3MTYzMzcyODksIuaAp-WIqyI6IueUtyJ9.QvDhEQEH6kwjgeD-ozAr5CjZ9-sMKWqEmAXBKf-bwKA


//    解析Jwt令牌
    @Test
    public void Getbody()
    {
        String s="you-boyfriend";
        byte[] hxc = s.getBytes(StandardCharsets.UTF_8);
        Claims body = Jwts.parser()
                .setSigningKey(hxc) //传入令牌密钥的字节数组
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyLlkI3lrZciOiLpn6nlhYjmpZoiLCJzdWIiOiJKV1Tku6TniYwiLCLniLHlpb0iOiLlr7wiLCJleHAiOjE3MTYzMzcyODksIuaAp-WIqyI6IueUtyJ9.QvDhEQEH6kwjgeD-ozAr5CjZ9-sMKWqEmAXBKf-bwKA")
                //传入jwt字符串
                .getBody();
        //获取密钥体的JSON数据
        System.out.println(body);
    }
    @Test
    public void operate()
    {
        OperateLog log = new OperateLog();
        log.setOperateUser(2);
        log.setClassName("ALLemps");
        log.setMethodName("Deleapp");
        log.setMethodParams("999");
        log.setReturnValue("noreturbn");
        log.setCostTime(24);
        emp.operateLog(log);
    }
    //获取Ioc容器的对象并调用其方法来获取bean
    @Autowired
    private ApplicationContext context;
    @Test
    public void IocBean()
    {
        //根据bean名称获取bean
        DeptController controller = (DeptController)context.getBean("deptController");
        System.out.println(controller);
        //根据bean的类型进行获取
        DeptController bean = context.getBean(DeptController.class);
        System.out.println(bean);
        //根据bean的名称和类型进行获取
        DeptController bean1 = context.getBean("deptController", DeptController.class);
        System.out.println(bean1);
    }

    @Test
    public void BeanText()
    {
        for (int i=0;i<10;i++)
        {
            DeptController bean = context.getBean(DeptController.class);
            System.out.println(bean);
        }
    }
   @Resource(name = "SayBean")
    private Hello hello;
    @Resource(name = "SAXReader")
    private SAXReader saxReader;

    @Autowired
    private HttpSession session;

//    @Autowired
//    private AnnotationConfigApplicationContext  applicationContext;

    @Test
    public void SayHello()
    {
//      hello.Say()0
        String id = session.getId();
        System.out.println(session.toString());
//        List<com.springboot.springboot01.projo.Emp> list1 = emp.query02(new HashMap());
//        for (com.springboot.springboot01.projo.Emp app : list1)
//        {
//            System.out.println(app.toString());
//        }
    }

//    @Autowired
//    private  HelloWorld helloWorld;
//    @Test
//    public void Gson()
//    {
//        helloWorld.SayHello();
//
//    }
}
