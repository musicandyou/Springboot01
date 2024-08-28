package com.springboot.springboot01.Service;

import com.springboot.springboot01.projo.Emp;
import com.springboot.springboot01.projo.Pagebean;

import java.util.Date;
import java.util.List;

/**
 * @author 韩先楚
 */
public interface DeptService {
    public List<Emp> Allemp();

    public List<Emp> AllDept();
 public void DeleDept(Integer id);

    //新增部门
    public Integer addDept(Emp emp);

    //分页查询员工
    //查询员工总记录数
    public Pagebean Addemp(Integer start ,Integer end);

   public List<Emp> quertemp(String name, Short gender, Date start, Date end);

    //根据Id批量删除员工
    void Deleempbyid(List<Integer> ids);

    //新增员工
    void saveemp(Emp emp);

    //根据id查询emp表的员工数据
    Emp Queryempbyid(Integer id);

    void UpdateempbyId(Emp emp);

    //登录验证
    Emp Login(Emp emp);
}
