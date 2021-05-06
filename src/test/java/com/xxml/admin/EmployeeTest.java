package com.xxml.admin;

import com.xxml.admin.bean.Employee;
import com.xxml.admin.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void query(){
        System.out.println(employeeMapper.selectById(1));
    }

//    @Test
//    void add(){
//        Employee hehe = new Employee(null, "hehe", "hehe@csa.com", 1, 18);
//        employeeMapper.insert(hehe);
//
//        // 插入后可以立即得到主键
//        System.out.println(hehe);
//    }
//    @Test
//    void update(){
//        Employee hehe = new Employee(5, "lining", "hehe@linig.com", 1, 18);
//        employeeMapper.updateById(hehe);
//
//        // 插入后可以立即得到主键
//        System.out.println(hehe);
//    }

    @Test
    void delete(){
        employeeMapper.deleteById(5);
    }

    @Test
    void list(){
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("gender", 0);
//        List<Employee> employees = employeeMapper.selectByMap(null);
        List<Employee> employees = employeeMapper.selectByMap(columnMap);
        System.out.println(employees);
    }
}
