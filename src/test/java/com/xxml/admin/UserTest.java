package com.xxml.admin;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.xxml.admin.bean.User;
import com.xxml.admin.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        assertEquals(28, userList.size());
        userList.forEach(System.out::println);
    }


}
