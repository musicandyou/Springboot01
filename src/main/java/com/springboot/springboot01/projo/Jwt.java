package com.springboot.springboot01.projo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 韩先楚
 */
public class Jwt {
  static  String s= "hxc";

  //生成Jwt令牌
    public static String GetJwt(Map<String,Object> claims) {
        byte[] key = s.getBytes(StandardCharsets.UTF_8);
        String Jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                .compact();
        return Jwt;
    }

    //解析jwt令牌
    public static Claims ParseJwt(String Jwt)
    {
        byte[] key = s.getBytes(StandardCharsets.UTF_8);
        Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(Jwt)
                .getBody();
          return body;
    }
//        Map<String,Object> map = new HashMap();
//        String s="you-boyfriend";
//        byte[] hxc = s.getBytes(StandardCharsets.UTF_8);
//        map.put("名字","韩先楚");
//        map.put("性别","男");
//        map.put("爱好","导");
//        String Jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256,hxc)
//                //设置密钥和数字算法,用于数字签名计算 注意传入的要为一个字节数组
//                .setClaims(map)
//                //设置自定义数据
//                .setSubject("JWT令牌")
//                //设置jWT主题 通常是用户id或用户名
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 10000))
//                //设置密钥使用时间日期
//                .compact();
//        System.out.println(Jwt);





}
