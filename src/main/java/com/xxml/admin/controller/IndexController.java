package com.xxml.admin.controller;

import com.xxml.admin.bean.City;
import com.xxml.admin.bean.User;
import com.xxml.admin.interceptor.RedisUrlCountInterceptor;
import com.xxml.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("/city")
    public City insertCity(City city){
        cityService.insertCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    /**
     * login page
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){
     return "login";
    }

    @PostMapping("/login")
    public String index(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            // login succeed redirect to index.html 重定向防止表单重新提交
            return "redirect:/index.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return  "login";
        }
    }

    /** go index page
     * @return
     */
    @GetMapping("/index.html")
    public String indexPage(HttpSession session, Model model){

        // 是否登录 拦截器 过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "index";
//        }else{
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s = operations.get("/index.html");
        String s1 = operations.get("/sql");

        model.addAttribute("indexCount", s);
        model.addAttribute("sqlCount", s1);
        return "index";
    }
}
