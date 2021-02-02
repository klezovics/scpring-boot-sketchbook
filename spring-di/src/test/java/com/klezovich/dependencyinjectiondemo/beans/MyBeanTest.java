package com.klezovich.dependencyinjectiondemo.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {MyBean.class})
@TestPropertySource(properties = {"app.Id=testBeanId","app.alias=testBeanAlias"})
class MyBeanTest {

    @Autowired
    private MyBean bean;

    @Test
    void testValueInjection() {
        assertEquals("testBeanId",bean.getId());
        assertEquals("testBeanAlias",bean.getAlias());
    }
}