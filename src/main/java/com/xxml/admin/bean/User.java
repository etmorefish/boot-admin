package com.xxml.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {
    /**
     * mybatisPlus 会默认将 bean 类当成表名，如果表名和类名不一致，可以使用注解
     * 所有属性都应该在数据库中
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    // database filed
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
