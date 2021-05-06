package com.xxml.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxml.admin.bean.Employee;
import com.xxml.admin.mapper.EmployeeMapper;
import com.xxml.admin.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * service 实现类  继承mp提供的通用的service基类
 * ServiceImpl<EmployeeMapper, Employee>
 *     2个泛型 1、EmployeeMapper Mapper 接口
 *            2、Employee对应 Bean
 */
@Service   // 注入到ioc容器
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
