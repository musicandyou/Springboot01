package com.springboot.springboot01.projo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author 韩先楚
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "my")
public class User {
private String name;
private Integer age;
 private Integer id;
private Date time;
private String firstname;
private String[] Hobby;
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
