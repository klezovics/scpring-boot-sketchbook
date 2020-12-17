package com.klezovich.springretry.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class MyServiceRetryTest {

    @Autowired
    private MyService service;

    @BeforeEach
    void setup() {
        service.resetRetryCounter();
    }

    @Test
    void testRetry() {
        service.retry(-1);
        assertThat(service.getRetryCount(), is(2));
    }

    @Test
    void testRetryAndRecover() {
        service.retryAndRecover(-1);
        assertThat(service.getRetryCount(), is(3));
    }
}
