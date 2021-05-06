package com.xxml.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxml.admin.bean.Employee;
import com.xxml.admin.mapper.EmployeeMapper;
import com.xxml.admin.service.EmployeeService;
import io.lettuce.core.dynamic.annotation.Param;
import io.micrometer.core.annotation.TimedSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class EmployeeTest2 {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper mapper;

    @Test
    void query() {
        int count = employeeService.count();
        List<Employee> list = employeeService.list();
        System.out.println(count);
        System.out.println(list);
    }

    // 插入 1 条记录
//    @Test
//    void insert() {
//        Date date = new Date();
//        Employee employee = new Employee(null, "idea", "idea@sas.com", 1, 19);
//        employeeService.save(employee);
//        System.out.println(employee);
//    }

    @Test
    void test() {
//        Employee employee = new Employee( 12,"tuling", "123@qq.com", 1, 18);
        Employee employee = new Employee();
//        Employee employee = employeeService.getById(22);
        employee.setAge(23);
        employee.setLastName("feier");
        employee.setEmail("tuling@cm.cd");
        employee.setGender(1);
        employeeService.saveOrUpdate(employee);

        System.out.println(employee);
    }

    // 插入 n 条记录
    @Test
    void insertBatch() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee obj = new Employee();
            obj.setAge(10 + i);
            obj.setEmail("batch@sa.com");
            obj.setGender(0);
            obj.setLastName("html" + i);
            employees.add(obj);
        }
        employeeService.saveBatch(employees);
    }

    //修改
    // 根据 ID 修改
    @Test
    void update() {
        Employee byId = employeeService.getById(20);
        byId.setEmail("idea@idea.com");
        employeeService.saveOrUpdate(byId);
        System.out.println(byId);
    }

    // 分页
    @Test
    void page(){
        IPage<Employee> iPage = new Page<>(1, 10);
        IPage<Employee> page = employeeService.page(iPage);

        List<Employee> records = page.getRecords();
        long total = page.getTotal();
        System.out.println(records);
        System.out.println(total);
        System.out.println(page.getPages());

    }

    @Test
    void xmlpage(){
        IPage<Employee> iPage = new Page<>(1, 10);
        System.out.println(mapper.getByGender(iPage, 0).getRecords());
    }


    /**
     * Wrapper 条件构造
     */
    @Test
    void contextLoads(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("last_name", "age")
                .eq("last_name", "Tom");

        System.out.println(employeeService.list(queryWrapper));
    }
    @Test
    void between(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .between("age", "20", 30)
                .inSql("id", "select 1 from employee");

        System.out.println(employeeService.list(queryWrapper));
    }
    @Test
    void updateWrapper() {
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
//        updateWrapper
////                .set("last_name", "xushu")
//                .setSql("last_name='xushu'")
//                .eq("id", 1);
        updateWrapper.lambda()
                .set(Employee::getLastName,"xxml")
                .eq(Employee::getId,1);
        System.out.println(employeeService.update(updateWrapper));
    }

    @Test
    void logicDelete(){
        employeeService.removeById(9);
    }
    @Test
    void list(){
        System.out.println(employeeService.list());
    }

    @Test
    void getById(){
        Employee employee = employeeService.getById(1);
        System.out.println(employee);
    }


    @Test
    void testCAS(){

        // 线程1  age:50  version:1
        Employee employee1 = employeeService.getById(1);

        // 线程2 age:50  version:1
        Employee employee2 = employeeService.getById(1);

        employee1.setAge(20);

        employee2.setAge(80);

        //   update 100  version:2  where  version1 =数据库version1
        if(employeeService.updateById(employee1)){
            System.out.println("更新成功");
        }

        //    update 100  version:2 where version1 =数据库version2
        if(!employeeService.updateById(employee2)){
            System.out.println("更新失败，请重新刷新页面并更新");
        }

    }

















}
