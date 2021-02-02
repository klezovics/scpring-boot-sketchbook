package com.klezovich.dependencyinjectiondemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Bean1.class, SrcBean.class})
class Bean1Test {

    @Autowired
    Bean1 bean;

    @Test
    void testValueAnnotation() {
        assertEquals("Arthur Klezovich", bean.getBeanAuthor());
        assertEquals("appFileValue", bean.getValueFromFile());
        assertEquals(42, bean.getAnswerToAll());
        assertEquals(100, bean.getSum());
        assertEquals("appJvmValue", bean.getValueFromJvm());
        assertEquals("MY_ENV_VALUE", bean.getValueFromEnv());
        assertEquals("srcFieldValue", bean.getFromSrcBeanField());
        assertEquals("srcMethodValue", bean.getFromSrcMethodField());
        assertEquals(true, bean.isMyBoolean());
        assertTrue(bean.getDateStr().length() > 0);
        assertEquals("forSetter", bean.getFromSetter());
        assertEquals("forConstructor", bean.getFromConstructor());
        assertEquals("both_values", bean.getFromDoubleSetter1());
        assertEquals("both_values", bean.getFromDoubleSetter2());
    }

}