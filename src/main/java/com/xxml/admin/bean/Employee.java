package com.xxml.admin.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("employee")
public class Employee {
    /**
     *  mybatisPlus 会自动将 bean 类中名字为 id的属性 当成主键
     *  如果主键没有赋值 那么他就会帮你使用 ID_WORKER 的生成策略
     *  如果字段是自动增长，需要我们是手动改策略
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
}
