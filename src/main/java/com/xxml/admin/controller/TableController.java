package com.xxml.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxml.admin.bean.User;
import com.xxml.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {


    @Autowired
    UserService userService;

    @GetMapping("basic_table")
    public String basic_table(){

        return "table/basic_table";
    }
    @GetMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        User user = userService.getById(id);
        user.setAge(88);
//        userService.saveOrUpdate(user);
//        userService.update();
        userService.save(user);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                Model model){
//        // 表格内容的遍历
//        List<User> users = Arrays.asList(new User("aj", "123456"),
//                new User("ah1", "1232"),
//                new User("ah2", "123ew2"),
//                new User("ah3", "12322"),
//                new User("ah4", "12ds32"));
//        model.addAttribute("users",users);

        List<User> list = userService.list();
//        model.addAttribute("users", list);

        //从数据库中查出user表中的用户进行展示

        //构造分页参数
        Page<User> page = new Page<>(pn, 10);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);

        System.out.println("-----");
        System.out.println(userPage.getCurrent());
        System.out.println(userPage.getTotal());
        System.out.println(userPage.getPages());

        model.addAttribute("users",userPage);

        return "table/dynamic_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(Model model){

        List<User> list = userService.list();
        model.addAttribute("users", list);

        User user = new User();
        user.setName("haha");
        user.setAge(89);
        user.setEmail("121@12.com");

        userService.save(user);
//        userService.save();

        return "table/editable_table";
    }
}
