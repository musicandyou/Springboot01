package com.springboot.springboot01.Dao;

import com.springboot.springboot01.projo.Emp;
import com.springboot.springboot01.projo.Temp;
import com.springboot.springboot01.projo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 韩先楚
 */
@Mapper
public interface Text02{
    @Delete("delete from manage where id01= #{id}")
    public Integer abc(Integer id);

    @Select("select count(*)  from manage where firstname = ${name} ")
    public Integer abc01(String name);

    @Options(useGeneratedKeys = true, keyProperty = "id") //获取返回的主键值并附给对象的id属性
    @Insert("insert into text values (#{id},#{name},#{time})")
    public Integer In(Temp temp);

//    @Select("select firstname from manage where firstname like concat(#{name},'%')")
    public List<User> app01(String name);

     public  void  Dele01(List<Integer> list);

//    查询全部员工信息
    @Select("select * from emp ")
    public List<Emp> EmpAll();

    //查询全部部门信息信息
    @Select("select * from dept")
    public List<Emp> Dempall();

    //根据id来删除部门
    @Delete("delete from dept where id= #{id}")
    public Integer DeleDept(Integer id);

    //新增部门
    @Insert("insert into dept(name, create_time, updata_time) values (#{name},now(),now() )")
    public Integer addDept(Emp emp);

    //根据部门id删除对应员工
    @Delete("delete from emp where dept_id = #{id}")
    public void Delefromid(Integer id);
}
