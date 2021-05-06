package com.xxml.admin.bean;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("employee")
public class Employee {
    /**
     *  mybatisPlus 会自动将 bean 类中名字为 id的属性 当成主键
     *  如果主键没有赋值 那么他就会帮你使用 ID_WORKER 的生成策略
     *  如果字段是自动增长，需要我们是手动改策略
     *
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    // 1代表有效数据  0代表删除的数据
//    @TableLogic(value = "1",delval = "0")
    private Integer enabled;
    // 创建时间：希望在添加数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

    @Version
    private Integer version;
}
