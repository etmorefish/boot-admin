package com.xxml.admin.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxml.admin.bean.User;
import com.xxml.admin.mapper.UserMapper;
import com.xxml.admin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
