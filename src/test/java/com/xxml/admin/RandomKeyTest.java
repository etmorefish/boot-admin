package com.xxml.admin;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;

public class RandomKeyTest {
    @Test
    void test(){
        // 生成 16 位随机 AES 密钥
//        String randomKey = AES.generateRandomKey();
//        System.out.println(randomKey);

       String randomKey =  "5a3fa229f6ca46c6";

// 随机密钥加密
        String url =  "jdbc:mysql://0.0.0.0:3306/test";
        String username =  "root";
        String password = "123456";
        String encrypt = AES.encrypt(url, randomKey);
        String encrypt1 = AES.encrypt(username, randomKey);
        String encrypt2 = AES.encrypt(password, randomKey);

        System.out.println(encrypt);
        System.out.println(encrypt1);
        System.out.println(encrypt2);
//        drUrYiMDYdOp5e2sIDmIg7yjDt+u0O/vGkA7ri6pNY0=
//        A8/w4XVIJou2uNw3x1LXwg==
//        UxYizXwIfgpwgg6iFLYRkA==
    }
}
