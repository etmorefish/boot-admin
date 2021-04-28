package com.xxml.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxml.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
