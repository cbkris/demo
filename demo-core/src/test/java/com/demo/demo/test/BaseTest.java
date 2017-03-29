package com.demo.demo.test;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cb on 2017/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplicationTest.class)
@Transactional
public class BaseTest {
    public static void main(String[] args) {
        SpringApplication.run(BaseTest.class, args);
    }
}
