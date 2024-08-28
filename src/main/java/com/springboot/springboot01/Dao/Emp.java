package com.springboot.springboot01.Dao;

import com.springboot.springboot01.projo.OperateLog;
import com.springboot.springboot01.projo.Pagebean;
import com.springboot.springboot01.projo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 韩先楚
 */
@Mapper
public interface Emp {

    //查询员工总记录数
    @Select("select count(*) from emp")
    public long Addemp();

    //分页查询员工
    @Select("select * from emp limit #{start},#{end}")
    public List<com.springboot.springboot01.projo.Emp> emps(Integer start,Integer end);

//查询全部员工信息
    @Select("select * from emp")
    public List<com.springboot.springboot01.projo.Emp> Addemps();

    //根据name,gender,entry_time 来查询员工
    public List<com.springboot.springboot01.projo.Emp> queryemp(String name, Short gender, Date start,Date end);

    //根据Id批量删除员工
    public void Deleempbyids(List<Integer> ids);

    //新增员工
    public void saveemps(com.springboot.springboot01.projo.Emp emp);

    //根据id查询emp表的员工数据
    @Select("select * from emp where id = #{id}")
    public com.springboot.springboot01.projo.Emp queryByid(Integer id);

    //根据id修改emp员工数据
    public void Updatabyid(com.springboot.springboot01.projo.Emp emp);

    //登录验证
    @Select("select * from emp where username= #{username} and password=#{password}")
    public com.springboot.springboot01.projo.Emp Login(com.springboot.springboot01.projo.Emp emp);

    //记录对数据库表的增删改操作的日志
    @Insert("insert into operate_log(operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time)\n" +
            "values(#{operateUser},now(),#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    public void operateLog(OperateLog operateLog);

     public List<com.springboot.springboot01.projo.APP> query01();

     public List<com.springboot.springboot01.projo.Emp> query02(HashMap hashMap) ;

}
