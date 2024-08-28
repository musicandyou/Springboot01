package com.springboot.springboot01.Service.Deptservice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot01.Dao.Text02;
import com.springboot.springboot01.Service.DeptService;
import com.springboot.springboot01.anno.OprateLog;
import com.springboot.springboot01.projo.Emp;
import com.springboot.springboot01.projo.Pagebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 韩先楚
 */
@Service
public class empAll implements DeptService {
    @Autowired
    private Text02 text02;
    @Autowired
    private com.springboot.springboot01.Dao.Emp emp;
    @Override
//    查询全部员工信息
    public List<Emp> Allemp() {
        return text02.EmpAll();
    }
    //查询全部部门信息信息
    public List<Emp> AllDept()
    {
        return text02.Dempall();
    }

    @Override
    @OprateLog
   @Transactional(rollbackFor = Exception.class)
    public void DeleDept(Integer id) {
      //1.先根据id删除相关的员工
            text02.Delefromid(id);

        //2.再删除部门
        text02.DeleDept(id);
    }

    //新增部门
    @Override
    @OprateLog
    public Integer addDept(Emp emp) {
        return text02.addDept(emp);
    }

    //分页查询员工
    @OprateLog
    @Override
    public Pagebean Addemp(Integer start ,Integer end) {
        //传统方式实现分页查询
//        long log = emp.Addemp();
//        List<Emp> emps = emp.emps(start, end);
//          return new Pagebean(log,emps);

        //使用pagehelper插件实现分页查询
        //1.设置分页参数
        PageHelper.startPage(start,end);
        //2.执行查询
        List<Emp> emps = emp.Addemps();
        Page<Emp> p=(Page<Emp>) emps;
        //3.封装对象
    return     new Pagebean(p.getTotal(),p.getResult());
    }

    //根据name,gender,entry_time 来查询员工
    @Override
    public List<Emp> quertemp(String name, Short gender, Date start, Date end) {
    return     emp.queryemp(name,gender,start,end);
    }

    //根据Id批量删除员工
    @Override
    @OprateLog
    public void Deleempbyid(List<Integer> ids) {
        emp.Deleempbyids(ids);
    }

    //新增员工
    @Override
    @OprateLog
    public void saveemp(Emp emps) {
        emps.setCreateTime(new Date());
        emps.setUpdateTime(new Date());
       emp.saveemps(emps);
    }

    @Override
    //根据id查询emp表的员工数据
    public Emp Queryempbyid(Integer id) {
        return emp.queryByid(id);
    }

    @Override
    @OprateLog
    //根据id修改emp员工数据
    public void UpdateempbyId(Emp emps) {
        emp.Updatabyid(emps);
    }

    @Override
    //登入验证
    public Emp Login(Emp emps) {
     return   emp.Login(emps);
    }


}
