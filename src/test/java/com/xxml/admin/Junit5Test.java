package com.xxml.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DisplayName("Junit5 功能测试类")
public class Junit5Test {

    @DisplayName("测试 displayname 注解")
    @Test
    void testDisplayName(){
        System.out.println("1");
    }

    @DisplayName("测试 displayname 2 注解")
    @Test
    void testDisplayName2(){
        System.out.println("2");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试开始了");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(5)
    @Test
    void testRepeatTest(){
        System.out.println(5);
    }

    @Test
    @DisplayName("simple assertion")
    public void simple() {
        assertEquals(3, 1 + 2, "simple math");
        assertNotEquals(3, 1 + 1);

        assertNotSame(new Object(), new Object());
        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 12}, "err");
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }


    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

}
