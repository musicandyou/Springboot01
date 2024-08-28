package com.springboot.springboot01.Controller;

import com.springboot.springboot01.Dao.Text02;
import com.springboot.springboot01.Service.DeptService;
import com.springboot.springboot01.projo.Emp;
import com.springboot.springboot01.projo.Pagebean;
import com.springboot.springboot01.projo.Result;
import com.springboot.springboot01.projo.Upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 韩先楚
 */
@Slf4j
@CrossOrigin
//@Lazy //第一次使用bean时实例化交给Ioc
@RestController
//@Scope("prototype")
public class DeptController {
    @Autowired
    private DeptService deptService;
    //查询全部员工信息 /ok
    @GetMapping("/depts")
    public Result list()
    {
        log.info("查询全部员工信息");
        List<Emp> allemp = deptService.Allemp();
       if (allemp.size()==0)
           return Result.error("查询失败");
       else
           return Result.success(allemp);
    }
    //查询全部部门信息信息 /ok
    @GetMapping("/emps")
    public Result list01()
    {
        log.info("查询全部部门信息信息");
        List<Emp> allemp = deptService.AllDept();
        if (allemp.size()==0)
            return Result.error("查询失败");
        else
            return Result.success(allemp);
    }
    public DeptController()
    {
        System.out.println("DeptController 对象被实例化了");
    }
    //根据id来删除部门 /ok
    @DeleteMapping("/dele/{id}")
    public Result DeleDept(@PathVariable Integer id)
    {
            deptService.DeleDept(id);
            return Result.success();
    }

    //新增部门 ok
    @PostMapping("/add_dept")
    public Result addDept(Emp emp)
    {
          deptService.addDept(emp);
           return Result.success();
    }

// 分页查询员工
    @GetMapping("/emp")
    public Result Queryemp(@RequestParam(defaultValue = "1") Integer start,@RequestParam(defaultValue = "10") Integer end){
        Pagebean addemp = deptService.Addemp(start, end);
        return Result.success(addemp);
    }

    //根据name,gender,entry_time 来查询员工
    @GetMapping("/queryemp")
    public Result queryemps(
            String name,Short gender ,
            @DateTimeFormat(pattern = "yy-MM-dd") Date start,
            @DateTimeFormat(pattern = "yy-MM-dd") Date end
    )
    {
        List<Emp> quertemp = deptService.quertemp(name, gender, start, end);
        return Result.success(quertemp);
    }

    //根据Id批量删除员工 /ok
 @DeleteMapping("/emps/{ids}")
 public Result empDelebyid(@PathVariable List<Integer> ids)
 {
     for (Integer i : ids)
         System.out.println(i);

     if (ids.size()==0)
         return Result.error("没有Id数据");
     else
     {
         try {
             deptService.Deleempbyid(ids);
             return Result.success();
         } catch (Exception e) {
             return Result.error(e.getMessage());
         }
     }
 }

 //新增员工 /ok
    @PostMapping("/addemp")
    public Result save(Emp emp)
    {
        try {
            deptService.saveemp(emp);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    //文件上传
    @PostMapping ("/upload")
    public void upLoad(String name,Integer age,MultipartFile image) throws IOException {
        //获取传过来的文件名 有后缀 如 JPG txt
        String name1 = image.getOriginalFilename();
      //  通过UUid类获取不同的值,防止不同用户的文件名相同发生文件替换问题
        String uuid = UUID.randomUUID().toString();
        //取出文件的文件类型 如jpg
        int i = name1.lastIndexOf(".");
        String s = name1.substring(i, name1.length());
      //将取出的类型和uuid进行拼接 文件放在D盘 image文件夹下
        image.transferTo(new File("D:\\image\\"+uuid+s));
        System.out.println(uuid+s);
    }

    //根据id查询emp表的员工数据
    @GetMapping("query_empbyid/{id}")
    public Emp query_empbyid(@PathVariable Integer id)
    {
        return deptService.Queryempbyid(id);
    }

    //根据id修改emp员工数据
    @PutMapping("/updateempbyid")
    public Result Updateempbyid(Emp emp)
    {
        try {
            deptService.UpdateempbyId(emp);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
